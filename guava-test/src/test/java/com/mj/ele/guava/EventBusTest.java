package com.mj.ele.guava;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * Created by majun on 15/10/1.
 */
public class EventBusTest {
    @Test
    public void should_create_event_bus_instance() throws Exception {
        EventBus eventBus = new EventBus();
        EventBus eventBus1 = new EventBus("My Event Bus");
    }


    @Test
    public void should_publish_event_message_in_serial_manner() throws Exception {
        EventBus eventBus = new EventBus();
        CookieContainer cookieContainer=new CookieContainer(eventBus);
        HandlerService cookieSeller = new CookieSeller(eventBus);
        HandlerService cookieMallBoss = new CookieMallBoss(eventBus);

        //设置cookie的数量为3
        cookieContainer.setNumberOfCookie(3);
        //用户取三次之后cookie数量为空
        cookieContainer.getACookie();
        cookieContainer.getACookie();
        cookieContainer.getACookie();
        System.out.println("=======触发事件发布============");
        cookieContainer.getACookie();
    }


}
