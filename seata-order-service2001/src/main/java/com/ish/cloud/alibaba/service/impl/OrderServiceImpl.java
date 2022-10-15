package com.ish.cloud.alibaba.service.impl;

import com.ish.cloud.alibaba.entity.Order;
import com.ish.cloud.alibaba.mapper.OrderDao;
import com.ish.cloud.alibaba.service.AccountService;
import com.ish.cloud.alibaba.service.OrderService;
import com.ish.cloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: ish
 * Date: 2022/10/12 21:39
 * Describe:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    @Override
    public void create(Order order) {
        log.info("---> 开始创建订单");
        orderDao.create(order);

        log.info("---> 订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---> 订单微服务开始调用库存，做扣减end");

        log.info("---> 订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("---> 订单微服务开始调用账户，做扣减end");

        // 修改订单的状态
        log.info("---> 修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("---> 修改订单状态结束");

        log.info("---> 下订单结束");
    }
}
