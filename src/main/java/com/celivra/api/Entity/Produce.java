package com.celivra.api.Entity;

import lombok.Data;

@Data
public class Produce {
    Long id;
    String name;
    double price;
    int quantity;
    String brand;
    String type;
    String description;
}
