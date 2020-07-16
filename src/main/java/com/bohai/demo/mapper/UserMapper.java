package com.bohai.demo.mapper;

import com.bohai.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     *  根据用户名查询用户结果集
     * @param username  用户名
     * @return  查询结果
     */
    @Select("select * from t_user where username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    /**
     * 保存用户信息
     * @param user  用户信息
     * @return 成功 1 失败 0
     */
    int insert(User user);
}
