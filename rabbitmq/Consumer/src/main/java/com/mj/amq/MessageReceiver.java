package com.mj.amq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by majun on 15/10/9.
 */

public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }

    public static void main(String[]args){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }
}
