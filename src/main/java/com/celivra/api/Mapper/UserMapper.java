package com.celivra.api.Mapper;

import com.celivra.api.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    User getUserById(Long id);
    @Update("update users set username = #{username}," +
            "email = #{email}, phone = #{phone}")
    boolean updateUser(User user);
}
