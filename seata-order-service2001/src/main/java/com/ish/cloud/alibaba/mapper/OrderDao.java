package com.ish.cloud.alibaba.mapper;

import com.ish.cloud.alibaba.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author: ish
 * Date: 2022/10/12 20:26
 * Describe:
 */
@Mapper
public interface OrderDao {
    /**
     * create   新建订单
     *
     * @param order order
     */
    void create(Order order);

    /**
     * update   修改订单状态
     *
     * @param userId userId
     * @param status status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
