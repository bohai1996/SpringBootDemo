package com.bohai.demo;

import com.bohai.demo.entity.User;
import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

//    @Test
//    void contextLoads() {
//        System.out.println("aaa");
//    }
    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception{
        System.out.println("1111");
        this.base = new URL("http://localhost:9090/demo/echo");
    }

    @Test
    public void testf(){
        System.out.println(port);
        System.out.println(base);
        ResponseEntity<String> forEntity = template.getForEntity(base.toString(), String.class);
        System.out.println(forEntity.getBody());

    }
    @Test
    public void test1() throws Exception{
        System.out.println("bbbb");
        template.postForEntity("http://localhost:9090/users",new User("user1","pass1"),Integer.class);
        log.info("[添加用户成功]\n");

        // TODo 如果是返回的集合，要用 exchange 而不是 getForEntity ,后者需要自己强转类型
        ResponseEntity<List<User>> response2 = template.exchange("http://localhost:9090/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        final List<User> body = response2.getBody();

        log.info("[查询所有] - [{}]\n",body);
        log.info("select * from user where id= 11");
        Long userId = body.get(0).getId();
        ResponseEntity<User> response3 = template.getForEntity("http://localhost:9090/users/{id}", User.class, userId);
        log.info("[主键查询] - [{}]\n",response3.getBody());
        template.put("http://localhost:9090/users/{id}",new User("user11","pass11"),userId);
        log.info("[修改用户成功]\n");
        template.delete("http://localhost:9090/users/{id}",userId);
        log.info("[删除用户成功]");
    }


}
