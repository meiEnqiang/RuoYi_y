package com.ruoyi.common.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue() {
        return new Queue("hello");
    }
    @Bean
    public Queue mailQueue() {
        return new Queue("mail");
    }
}
