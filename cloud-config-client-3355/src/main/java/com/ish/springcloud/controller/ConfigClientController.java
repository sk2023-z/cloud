package com.ish.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ish
 * Date: 2022/10/02 14:12
 * Describe:
 */
@RestController
// 刷新功能
@RefreshScope
/**
 * 需要发送POST请求去刷新
 * curl -X POST "http://localhost:3355/actuator/refresh"
 */
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
