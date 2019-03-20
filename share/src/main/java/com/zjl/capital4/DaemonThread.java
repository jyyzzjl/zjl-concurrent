package com.zjl.capital4;

import java.util.concurrent.TimeUnit;

public class DaemonThread {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            System.out.println("thread start ");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread end");
        });
        //设置t1为守护线程，注意只能在start前调用
        t1.setDaemon(true);
        t1.start();

        System.out.println("main thread end");
    }
}
