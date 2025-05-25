package com.celivra.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${spring.mail.username}")
    private String from;

    @PostMapping("/sendCode")
    public ResponseEntity<String> sendCode(@RequestParam String email) {
        String code = String.valueOf(new Random().nextInt(900000) + 100000); // 6位数字验证码

        // 发送邮件
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(email);
            message.setSubject("注册验证码");
            message.setText("您的验证码是：" + code + "，有效期5分钟。");
            mailSender.send(message);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("邮件发送失败");
        }

        // 存入 Redis，有效期5分钟
        redisTemplate.opsForValue().set("code:" + email, code, 5, TimeUnit.MINUTES);

        return ResponseEntity.ok("验证码已发送");
    }
}
