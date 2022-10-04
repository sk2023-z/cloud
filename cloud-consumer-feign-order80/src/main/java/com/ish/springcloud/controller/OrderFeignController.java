package com.ish.springcloud.controller;

import com.ish.springcloud.entities.CommonResult;
import com.ish.springcloud.entities.Payment;
import com.ish.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ish
 * Date: 2022/09/24 13:52
 * Describe:
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
