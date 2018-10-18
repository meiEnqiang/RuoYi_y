package com.ruoyi.common.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("接受信息C  : " + hello);
    }
}
