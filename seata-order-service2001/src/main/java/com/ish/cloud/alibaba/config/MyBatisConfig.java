package com.ish.cloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ish
 * Date: 2022/10/12 23:00
 * Describe:
 */
@Configuration
@MapperScan({"com.ish.cloud.alibaba.mapper"})
public class MyBatisConfig {
}
