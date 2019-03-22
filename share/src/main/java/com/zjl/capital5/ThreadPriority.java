package com.zjl.capital5;

import java.util.Optional;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for (int i=0;i<1000;i++){
                Optional.of(Thread.currentThread().getName()+"  "+i).ifPresent(System.out::println);
            }
        });
        Thread t2=new Thread(()->{
            for (int i=0;i<1000;i++){
                Optional.of(Thread.currentThread().getName()+"  "+i).ifPresent(System.out::println);
            }
        });
        Thread t3=new Thread(()->{
            for (int i=0;i<1000;i++){
                Optional.of(Thread.currentThread().getName()+"  "+i).ifPresent(System.out::println);
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

    }
}
