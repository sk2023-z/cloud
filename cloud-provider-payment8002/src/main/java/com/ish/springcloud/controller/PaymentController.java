package com.ish.springcloud.controller;


import com.ish.springcloud.entities.CommonResult;
import com.ish.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.ish.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        return result > 0 ? new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result) : new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("插入结果" + payment);
        return payment != null ? new CommonResult(200, "查询成功,serverPort: " + serverPort, payment) : new CommonResult(444, "没有对应记录，查询ID：" + id, null);
    }

    @GetMapping("payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
