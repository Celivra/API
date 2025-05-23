package com.celivra.api.Dto;

import lombok.Data;

@Data
public class LoginResponse {
    boolean success;
    String message;

    public LoginResponse(boolean b, String success) {
        this.success = b;
        this.message = success;
    }
}
