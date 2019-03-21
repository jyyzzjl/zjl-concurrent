package com.zjl.capital5;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 is running");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("t1 is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        //等待5秒，5秒后如果t1没执行完，主线程继续执行
        t1.join(5000);
        IntStream.range(0, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));

        Thread.currentThread().join();
    }
}
