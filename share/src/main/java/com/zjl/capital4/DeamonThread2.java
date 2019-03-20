package com.zjl.capital4;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DeamonThread2 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            //创建内部线程，设定为守护线程，主线程停止后依然会退出
           Thread innerThread=new Thread(()->{
               System.out.println("inner thread start");
               try {
                   TimeUnit.SECONDS.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("inner thread end");
           }) ;
           innerThread.setDaemon(true);
           innerThread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 thread end");
        });
        t1.setDaemon(true);
        t1.start();

        System.out.println("main thread start");

    }
}
