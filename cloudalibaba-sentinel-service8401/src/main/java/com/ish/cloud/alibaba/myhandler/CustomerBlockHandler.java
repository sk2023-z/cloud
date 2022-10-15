package com.ish.cloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ish.springcloud.entities.CommonResult;

/**
 * Author: ish
 * Date: 2022/10/10 23:31
 * Describe:
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444, "按客户自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "按客户自定义,global handlerException----2");
    }
}
