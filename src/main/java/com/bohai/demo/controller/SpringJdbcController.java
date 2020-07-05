package com.bohai.demo.controller;

import com.bohai.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class SpringJdbcController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringJdbcController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping
    public List<User> queryUsers(){
        String sql = "select * from t_user";
//        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(User.class));
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(User.class));
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        // 根据主键ID查询
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(User.class));
    }

    @DeleteMapping("/{id}")
    public int delUser(@PathVariable Long id){
        // id 删除用户信息
        String sql = "DELETE FROM t_user WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }

    @PostMapping
    public int addUser(@RequestBody User user){
        // 添加用户
        String sql = "insert into t_user(username,password) values(?,?)";
        return jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
    }
    @PutMapping("/{id}")
    public int editUser(@PathVariable Long id,@RequestBody User user){
        // id 修改用户信息
        String sql="update t_user set username=?,password=? where id=?";
        return jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),id);
    }




}
