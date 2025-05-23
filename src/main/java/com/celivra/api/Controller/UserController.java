package com.celivra.api.Controller;

import com.celivra.api.Dto.LoginRequest;
import com.celivra.api.Dto.LoginResponse;
import com.celivra.api.Entity.User;
import com.celivra.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        User user = userService.getUserByName(username);
        if(user == null){
            return new LoginResponse(false, "User not found", null);
        }
        if(password.equals(user.getPassword())) {
            return new LoginResponse(true, "Login Success", user);
        }
        else {
            return new LoginResponse(false, "Password incorrect", user);
        }

    }

}
