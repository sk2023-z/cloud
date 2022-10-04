package com.ish.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Author: ish
 * Date: 2022/09/25 21:32
 * Describe:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_Timeout";
    }
}
