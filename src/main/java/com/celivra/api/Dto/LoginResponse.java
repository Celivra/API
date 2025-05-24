package com.celivra.api.Dto;

import com.celivra.api.Entity.User;
import lombok.Data;

@Data
public class LoginResponse {
    boolean success;
    String message;
    User user;

    public LoginResponse(boolean b, String success, User user) {
        this.success = b;
        this.message = success;
        this.user = user;
    }
}
