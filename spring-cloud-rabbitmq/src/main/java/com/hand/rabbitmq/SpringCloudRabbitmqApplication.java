package com.hand.rabbitmq;

import com.hand.rabbitmq.client.RabbitMQClient;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class SpringCloudRabbitmqApplication {

    @Autowired
    private RabbitMQClient rabbitMQClient;

    @Bean
    public Queue testQueue() {
        return new Queue("hand");
    }

    @PostConstruct
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            String context = "hello " + new Date();
            System.out.println("Sender : " + context);
            rabbitMQClient.send("时间消息 ："+context);
        }
        stopWatch.stop();
        System.out.println("发送消息耗时：" + stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRabbitmqApplication.class, args);
    }
}
