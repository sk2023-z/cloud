package com.ish.cloud.alibaba.service;

import com.ish.cloud.alibaba.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Author: ish
 * Date: 2022/10/12 21:37
 * Describe:
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long id, @RequestParam("money") BigDecimal money);
}
