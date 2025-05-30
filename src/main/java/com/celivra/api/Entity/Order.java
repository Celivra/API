package com.celivra.api.Entity;

import lombok.Data;

@Data
public class Order {
    Long id;
    Long userId;
    Long productId;
    Long quantity;
    String status;
}
