package com.hand.rabbitmq.topic.client;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/2/1.
 * @description
 */
@Component
public class RabbitMQTopicClient {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private TopicExchange exchange;

    public void send(String message){
        this.rabbitTemplate.convertAndSend(exchange.getName(),"test",message);
    }
}
