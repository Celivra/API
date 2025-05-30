package com.celivra.api.Mapper;

import com.celivra.api.Entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    User getUserById(Long id);
    @Select("select * from users where username = #{username}")
    User getUserByName(String username);
    @Select("select * from users where email = #{email}")
    User getUserByEmail(String email);
    @Insert("insert into users(username, password, email, phone) values(#{username}, #{password} ,#{email}, #{phone})")
    boolean insert(User user);
    @Update("update users set username = #{username}," +
            "password = #{password}, email = #{email}, phone = #{phone}")
    boolean update(User user);
    @Delete("delete from users where id = #{id}")
    boolean delete(Long id);
    @Select("select * from users")
    List<User> getAllUser();
}
