package com.celivra.api.Dto;

import lombok.Data;

@Data
public class RegisterResponse {
    boolean success;
    String message;
    public RegisterResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
