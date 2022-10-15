package com.ish.cloud.alibaba.ctroller;

import com.ish.springcloud.entities.CommonResult;
import com.ish.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Author: ish
 * Date: 2022/10/11 0:07
 * Describe:
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Long, Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put(1L, new Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        paymentMap.put(2L, new Payment(2L, "bba8c1e3bc2742d8848569891ac32182"));
        paymentMap.put(3L, new Payment(3L, "6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = paymentMap.get(id);
        return new CommonResult<Payment>(200, "from mysql,serverPort:  " + serverPort, payment);
    }
}
