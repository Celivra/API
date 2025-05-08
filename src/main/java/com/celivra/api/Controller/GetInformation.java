package com.celivra.api.Controller;

import com.celivra.api.Entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/user")
public class GetInformation {
    @PostMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
    }
}
