package com.hand.stream.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/8/30.
 * @description
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger log = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receiver(String message) {
        log.info("Received: " + message);
        System.out.println("Received: " + message);
    }
}
