package com.ish.cloud.alibaba.controller;

import com.ish.cloud.alibaba.entity.CommonResult;
import com.ish.cloud.alibaba.entity.Order;
import com.ish.cloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: ish
 * Date: 2022/10/12 22:40
 * Describe:
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
