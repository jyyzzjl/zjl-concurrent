package com.zjl.capital6;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                }
            }
        };
        Thread main = Thread.currentThread();
        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打断t1并不会导致join被打断，因为join指的是主线程
//            t1.interrupt();
            main.interrupt();
        });
        t2.start();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("t1 is interrupted");
            e.printStackTrace();
        }

    }


}
