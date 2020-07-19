package com.bohai.demo;

import com.bohai.demo.entity.TUser;
import com.bohai.demo.entity.User;
import com.bohai.demo.mapper.UserListMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTest {
    private static final Logger log = LoggerFactory.getLogger(PageTest.class);

    @Autowired
    private UserListMapper userListMapper;

    @Test
    public void test1() throws Exception {

        final TUser user1 = new TUser("u342421","p1");
        userListMapper.insertSelective(user1);

        log.info("[user1回写主键] - [{}]",user1.getId());

        final int u1 = userListMapper.countByUsername("u1");
        log.info("[调用自定义的SQL]- [{}]",u1);

        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询 有了这两款插件无缝切换各种数据库

        PageInfo<Object> page = PageHelper.startPage(1, 2).setOrderBy("id desc").doSelectPageInfo(
                () -> this.userListMapper.selectAll()
        );
        log.info("[lambda写法] - [分页信息] - [{}]",page.toString());

        PageHelper.startPage(1,2).setOrderBy("id desc");
        PageInfo<TUser> userPageInfo = new PageInfo<TUser>(this.userListMapper.selectAll());
        log.info("[普通写法] - [{}]",userPageInfo);
    }
}
