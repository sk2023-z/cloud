package com.ish.cloud.alibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: ish
 * Date: 2022/10/12 19:46
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  msg;
    private T       data;

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
