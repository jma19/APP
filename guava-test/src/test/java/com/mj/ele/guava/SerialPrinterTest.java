package com.mj.ele.guava;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by majun on 15/10/12.
 */
public class SerialPrinterTest {

    @Test
    public void should_access_data_in_a_serial_way() throws Exception {
        final SerialPrinter serialPrinter = new SerialPrinter();

        new Thread(new Runnable() {
            public void run() {
                while (true){
                    serialPrinter.printA();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    serialPrinter.printB();
                }
            }
        }).start();


    }
}