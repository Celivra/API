package com.celivra.api.Mapper;

import com.celivra.api.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@Mapper
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    User getUserById(Long id);
    @Insert("insert into users(username, email, phone) values(#{username}, #{email}, #{phone})")
    boolean insertUser(User user);
    @Update("update users set username = #{username}," +
            "email = #{email}, phone = #{phone}")
    boolean updateUser(User user);
    @Delete("delete from users where id = #{id}")
    boolean deleteUserById(Long id);
}
