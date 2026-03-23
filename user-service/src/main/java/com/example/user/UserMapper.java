package com.example.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT id, name, email FROM user_tbl WHERE id = #{id}")
    User getUserById(String id);
}
