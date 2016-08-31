package com.mj.ele.guava;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * Created by majun on 15/10/1.
 */
public interface HandlerService {
    @AllowConcurrentEvents
    void handler(EmptyEvent emptyEvent);
}
