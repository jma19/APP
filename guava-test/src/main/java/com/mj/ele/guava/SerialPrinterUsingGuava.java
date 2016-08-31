package com.mj.ele.guava;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor.Guard;

import java.util.ArrayList;
import java.util.List;


public class SerialPrinterUsingGuava {
    private static final int MAX_SIZE = 10;
    private List<String> list = new ArrayList<String>();
    private Monitor monitor = new Monitor();

    private Guard listBelowCapacity = new Guard(monitor) {
        @Override
        public boolean isSatisfied() {
            return list.size() < MAX_SIZE;
        }
    };

    public void addToList(String item) throws InterruptedException {
        monitor.enterWhen(listBelowCapacity);
        try {
            list.add(item);
        } finally {
            monitor.leave();
        }
    }

   
}
