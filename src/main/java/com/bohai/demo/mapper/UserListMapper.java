package com.bohai.demo.mapper;

import com.bohai.demo.entity.TUser;
import com.bohai.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserListMapper extends BaseMapper<TUser> {


    /**
     * 根据用户名统计
     * @param username 用户名
     * @return 统计结果
     */
    int countByUsername(String username);
}
