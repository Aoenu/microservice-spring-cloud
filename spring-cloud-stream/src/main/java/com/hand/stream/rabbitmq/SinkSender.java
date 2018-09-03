package com.hand.stream.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/8/30.
 * @description
 */
@EnableBinding(Source.class)
public class SinkSender {

    private static Logger log = LoggerFactory.getLogger(SinkReceiver.class);

//    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "2000"))
//    public String timerMessageSource() {
//        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        log.info("Send Message: " + format);
//        System.out.println(format);
//        return format;
//    }
}
