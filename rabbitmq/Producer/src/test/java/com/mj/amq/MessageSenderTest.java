package com.mj.amq;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MessageSenderTest {

    private ApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void should_send_a_amq_message() throws Exception {
        MessageSender messageSender = (MessageSender) context.getBean("messageSender");
        for(int i=0;i<10;i++){
            messageSender.sendMessage("Hello, I am amq sender");
        }
    }
}