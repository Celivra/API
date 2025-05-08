package com.celivra.api.Controller;

import com.celivra.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class GetInformation {
    @Autowired
    UserService userService;
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id){
        System.out.println(id);
        return userService.getUser(id).toString();
    }
}
