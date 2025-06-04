package com.celivra.api.Service;

import com.celivra.api.Entity.Order;
import com.celivra.api.Mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public Order getOrder(Long id) {
        return orderMapper.getOrder(id);
    }
    public boolean insert(Order order) {
        return orderMapper.insert(order);
    }
    public boolean delete(Long id) {
        return orderMapper.delete(id);
    }
}
