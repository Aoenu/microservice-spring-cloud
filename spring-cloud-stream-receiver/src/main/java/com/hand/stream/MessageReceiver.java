package com.hand.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.Date;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/9/3.
 * @description
 */
@EnableBinding(Sink.class)
public class MessageReceiver {

    @StreamListener(Sink.INPUT)
    public void receiveMsg(String payload) {
        System.out.println(new Date() + " MessageReceiver: " + payload);
    }
}
