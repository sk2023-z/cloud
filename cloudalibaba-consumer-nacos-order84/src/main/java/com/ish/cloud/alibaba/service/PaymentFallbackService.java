package com.ish.cloud.alibaba.service;

import com.ish.springcloud.entities.CommonResult;
import com.ish.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * Author: ish
 * Date: 2022/10/11 19:39
 * Describe:
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回，--PaymentFallbackService",new Payment(id,"errorService"));
    }
}
