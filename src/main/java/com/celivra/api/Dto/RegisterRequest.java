package com.celivra.api.Dto;

import lombok.Data;

@Data
public class RegisterRequest {
    String username;
    String password;
    String email;
    String phone;
}
