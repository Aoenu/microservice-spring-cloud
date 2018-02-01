package com.hand.rabbitmq;

import com.hand.rabbitmq.direct.client.RabbitMQDirectClient;
import com.hand.rabbitmq.topic.client.RabbitMQTopicClient;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class SpringCloudRabbitmqApplication {

//    Direct 是 RabbitMQ 默认的交换机模式,也是最简单的模式.
//    即创建消息队列的时候,指定一个 BindingKey. 当发送者发送消息的时候,
//    指定对应的 Key. 当 Key 和消息队列的 BindingKey 一致的时候,消息将会被发送到该消息队列中.

//    @Autowired
//    private RabbitMQDirectClient rabbitMQDirectClient;
//
//    @Bean
//    public Queue testQueue() {
//        return new Queue("hand");
//    }

//      topic 转发信息主要是依据通配符, 队列和交换机的绑定主要是依据一种模式(通配符+字符串),
//      而当发送消息的时候,只有指定的 Key 和该模式相匹配的时候, 消息才会被发送到该消息队列中.
    @Bean
    public Queue testQueue() {
        return new Queue("hand-Queue");
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("hand-TopicExchange");
    }

    @Bean
    public Binding binging(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("test");
    }

    @Autowired
    public RabbitMQTopicClient rabbitMQTopicClient;



//    Fanout 是路由广播的形式, 将会把消息发给绑定它的全部队列, 即便设置了 key, 也会被忽略.
//    Fanout Exchange 形式又叫广播形式。
//
//    任何发送到 Fanout Exchange 的消息都会被转发到与该 Exchange 绑定(Binding)的所有 Queue 上。
//
//    这种模式需要提前将 Exchange 与 Queue 进行绑定，一个 Exchange 可以绑定多个 Queue，一个 Queue 可以同多个 Exchange 进行绑定
//    这种模式不需要 RoutingKey
//    如果接受到消息的 Exchange 没有与任何 Queue 绑定，则消息会被抛弃。

    @PostConstruct
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            String context = "hello " + new Date();
            System.out.println("Sender : " + context);
//            rabbitMQDirectClient.send("时间消息 ："+context);
            rabbitMQTopicClient.send("时间消息 ："+context);
        }
        stopWatch.stop();
        System.out.println("发送消息耗时：" + stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRabbitmqApplication.class, args);
    }
}
