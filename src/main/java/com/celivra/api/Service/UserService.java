package com.celivra.api.Service;

import com.celivra.api.Entity.User;
import com.celivra.api.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserById(Long id){
        return  userMapper.getUserById(id);
    }
    public User getUserByName(String username){
        return  userMapper.getUserByName(username);
    }
    public User getUserByEmail(String email){
        return  userMapper.getUserByEmail(email);
    }
    public boolean addUser(User user){
        return userMapper.insert(user);
    }
    public boolean updateUser(User user){
        return userMapper.update(user);
    }
    public boolean deleteUser(Long id){
        return userMapper.delete(id);
    }
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
}
