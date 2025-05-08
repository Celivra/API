package com.celivra.api.Entity;

import lombok.Data;

@Data
public class User {
    Long id;
    String username;
    String phone;
    String email;
}
