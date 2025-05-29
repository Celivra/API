package com.celivra.api.Controller;

import com.celivra.api.Dto.LoginRequest;
import com.celivra.api.Dto.LoginResponse;
import com.celivra.api.Dto.RegisterRequest;
import com.celivra.api.Dto.RegisterResponse;
import com.celivra.api.Entity.User;
import com.celivra.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest regR) {

        String key = "verify_code:" + regR.getEmail();
        String cachedCode = (String) redisTemplate.opsForValue().get(key);
        System.out.println(regR.getEmail());

        if (cachedCode == null) {
            return new RegisterResponse(false, "验证码已过期，请重新获取");
        }

        if (!cachedCode.equals(regR.getCode())) {
            return new RegisterResponse(false, "验证码错误");
        }

        // 验证通过，注册用户
        boolean success = userService.addUser(new User(
                regR.getUsername(),
                regR.getPassword(),
                regR.getPhone(),
                regR.getEmail()
        ));

        if (success) {
            redisTemplate.delete(key); // 注册成功后清除验证码
            return new RegisterResponse(true, "注册成功");
        } else {
            return new RegisterResponse(false, "注册失败，用户可能已存在");
        }
    }
    @PostMapping("/{id}")
    public User login(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if(user == null){
            return null;
        }
        return user;
    }
}
