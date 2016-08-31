package com.mj.amq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by majun on 15/10/2.
 */
@Service
public class MessageSender {

    @Resource(name="myAmqpTemplate")
    AmqpTemplate amqpTemplate;
    //
    public void sendMessage(Object message){
        amqpTemplate.convertAndSend("hello",message);
    }
}
