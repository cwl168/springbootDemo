package com.cawl.mybatis.mapper;

import com.cawl.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//mybatis基于注解的映射

@Mapper
public interface UserMapper {
    @Select("select * from users")
    public List<User> findAll();
}
