package com.mj.ele.guava;

import com.google.common.eventbus.EventBus;

/**
 * Created by majun on 15/10/1.
 */
public class CookieSeller implements HandlerService {

    public CookieSeller(EventBus eventBus) {
        eventBus.register(this);
    }

    public void handler(EmptyEvent emptyEvent) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getName() + ":" + "receiving empty event");
    }
}
