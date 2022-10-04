package com.ish.springcloud.service.impl;

import com.ish.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Author: ish
 * Date: 2022/10/03 19:40
 * Describe:
 */
@EnableBinding(Source.class) // 定义消息推送的管道
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("**************serial: " + serial);
        return null;
    }
}
