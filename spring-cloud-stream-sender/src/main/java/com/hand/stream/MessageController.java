package com.hand.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/9/3.
 * @description
 */
@RestController
public class MessageController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping("/send/{msg}")
    public String sendMessage(@PathVariable("msg") String msg) {
        messageSender.sendMsg(msg);
        return "sendMessage: " + msg;
    }
}
