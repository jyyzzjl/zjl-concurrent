package com.zjl.capital7;

import java.util.concurrent.TimeUnit;

public class SynchronizedThis {
    static class ThisLock {
        void m1() {
            synchronized (this) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized void m2() {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread(() -> {
            thisLock.m1();
        }, "t1").start();

        new Thread(() -> {
            thisLock.m2();
        }, "t2").start();
    }
}
