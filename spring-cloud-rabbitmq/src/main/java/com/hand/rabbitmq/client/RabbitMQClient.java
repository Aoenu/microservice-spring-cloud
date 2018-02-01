package com.hand.rabbitmq.client;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/2/1.
 * @description
 */
@Component
public class RabbitMQClient {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message){
        this.rabbitTemplate.convertAndSend("hand",message);
    }
}
