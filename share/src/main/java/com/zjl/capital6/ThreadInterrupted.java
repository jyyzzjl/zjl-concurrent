package com.zjl.capital6;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                //使用interrupte打断后，会捕捉异常
                System.out.println("thread is interrupted");
                e.printStackTrace();
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("main thread is done");
        t1.interrupt();
    }
}
