package com.ruoyi.common.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Configuration
public class FanoutRabbitConfig {
    @Bean
    public Queue messageA() {
        return new Queue("fanout.A");
    }
    @Bean
    public Queue teacher() {
        return new Queue("teacher");
    }
    @Bean
    public Queue messageB() {
        return new Queue("fanout.B");
    }
    @Bean
    public Queue messageC() {
        return new Queue("fanout.C");
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    Binding bindingExchangeA(Queue messageA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageA).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue messageB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageB).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue messageC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageC).to(fanoutExchange);
    }
}
