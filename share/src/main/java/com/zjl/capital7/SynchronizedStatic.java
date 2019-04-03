package com.zjl.capital7;

import java.util.concurrent.TimeUnit;

public class SynchronizedStatic {
    synchronized static void m1() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("m1 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void m2() {
//        synchronized (SynchronizedStatic.class){
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("m2 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SynchronizedStatic.m1();
        }, "T1").start();

        new Thread(() -> {
            SynchronizedStatic.m2();
        }, "T2").start();
    }
}
