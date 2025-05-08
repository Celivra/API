package com.celivra.api.Controller;

import com.celivra.api.Entity.User;
import com.celivra.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id){
        System.out.println(id);
        return userService.getUser(id).toString();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") @RequestBody User user){
        if(userService.updateUser(user)){
            return ResponseEntity.ok("更新成功");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
    }
}
