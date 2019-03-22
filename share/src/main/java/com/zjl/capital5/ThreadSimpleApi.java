package com.zjl.capital5;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ThreadSimpleApi {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Optional.of(t1.getName()).ifPresent(System.out::println);
        Optional.of(t1.getId()).ifPresent(System.out::println);
        Optional.of(t1.getPriority()).ifPresent(System.out::println);
    }

}
