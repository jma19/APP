package com.mj.ele.guava;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by majun on 15/10/12.
 */
public class SerialPrinter {

    private boolean isA = true;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public synchronized void printA() {

        while (!isA) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("print a");
        isA = false;
        notify();
    }

    public synchronized void printB() {
        while (isA) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("print b");
        isA = true;
        notify();
    }

}

