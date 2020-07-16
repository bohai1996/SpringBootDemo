package com.bohai.demo;

import com.bohai.demo.entity.JpaUser;
import com.bohai.demo.entity.User;
import com.bohai.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(JpaApplicationTests.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() throws Exception{
        final JpaUser user = userRepository.save(new JpaUser("u1","p1"));
        log.info("[添加成功] - ",user);
        final List<JpaUser> u1 = userRepository.findAllByUsername("u1");
        log.info("[条件查询] - [{}]",u1);
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
        final Page<JpaUser> users = userRepository.findAll(pageable);
        log.info("[分页+排序+查询所有] - [{}]",users.getContent());

        userRepository.findById(users.getContent().get(0).getId()).ifPresent(
                user1->log.info("[主键查询] - [{}]",user1));
        final JpaUser edit = userRepository.save(new JpaUser(user.getId(),"newui","newp1"));
        log.info("[修改成功] - [{}]",edit);
        userRepository.deleteById(user.getId());
        log.info("[删除主键为 {} 成功] - [{}]",user.getId());









    }
}
