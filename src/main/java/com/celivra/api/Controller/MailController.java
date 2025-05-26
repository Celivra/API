package com.celivra.api.Controller;

import com.celivra.api.Dto.EmailRequest;
import com.celivra.api.Dto.RegisterResponse;
import com.celivra.api.Service.UserService;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private UserService userService;

    @PostMapping("/sendCode")
    public RegisterResponse sendCode(@RequestBody EmailRequest email) {

        if(userService.getUserByEmail(email.getEmail()) != null){
            return new RegisterResponse(false, "邮箱已经存在了");
        }

        String code = String.valueOf(new Random().nextInt(900000) + 100000); // 6位数字验证码
        // 发送邮件
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");

            helper.setTo(email.getEmail());
            helper.setSubject("注册验证码");
            helper.setText("您的验证码是：" + code + "，有效期5分钟。");

            // 设置发件人邮箱和显示名称
            helper.setFrom(new InternetAddress(from, "Celivra", "UTF-8"));

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return new RegisterResponse(false, "邮箱发送失败");
        }

        // 存入 Redis，有效期5分钟
        redisTemplate.opsForValue().set("verify_code:" + email.getEmail(), code, 5, TimeUnit.MINUTES);


        return new RegisterResponse(true, "邮箱发送成功");
    }
}
