package com.celivra.api.Service;

import com.celivra.api.Controller.GetInformation;
import com.celivra.api.Entity.User;
import com.celivra.api.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUser(Long id){
        return  userMapper.getUserById(id);
    }
}
