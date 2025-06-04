package com.celivra.api.Controller;

import com.celivra.api.Entity.Order;
import com.celivra.api.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/get/{id}")
    public Order getOrder(@PathVariable("id") Long id){
        Order order = orderService.getOrder(id);
        if(order == null){
            return null;
        }
        return order;
    }
    @PostMapping("/create")
    public boolean createOrder(@RequestBody Order order){
        return orderService.insert(order);
    }
}
