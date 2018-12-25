package com.space.register.controller;

import com.space.register.dao.OrderRepository;
import com.space.register.entity.OrderEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderRepository orderRepository;

    @RequestMapping("/acceptOrder")
    public String acceptOrder(OrderEntity orderEntity) {
        System.out.println(orderEntity);
        OrderEntity save = orderRepository.save(orderEntity);
        if (save!=null) {
            return "true";
        } else {
            return "false";
        }
//        return "success";
    }
}
