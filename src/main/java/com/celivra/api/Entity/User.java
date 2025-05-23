package com.celivra.api.Entity;

import lombok.Data;

@Data
public class User {
    Long id;
    String username;
    String password;
    String phone;
    String email;
    public User(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}
