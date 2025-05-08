package com.celivra.api.Mapper;

import com.celivra.api.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    User getUserById(Long id);
}
