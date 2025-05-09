package com.celivra.api.Entity;

import lombok.Data;

@Data
public class User {
    Long id;
    String username;
    String phone;
    String email;
    public User(String username, String phone, String email) {
        this.username = username;
        this.phone = phone;
        this.email = email;
    }
}
