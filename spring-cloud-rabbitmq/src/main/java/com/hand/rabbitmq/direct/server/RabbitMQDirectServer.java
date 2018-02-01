package com.hand.rabbitmq.direct.server;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/2/1.
 * @description
 */
@Component
@RabbitListener(queues = "hand")
public class RabbitMQDirectServer {
    @RabbitHandler
    public void receive(String message){
        System.out.println("收到的message信息是："+message);
    }
}
