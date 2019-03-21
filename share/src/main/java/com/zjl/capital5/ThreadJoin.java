package com.zjl.capital5;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) {
        //0-1000循环，打印数据
        Thread t1 = new Thread(() -> IntStream.range(0, 1000).
                forEach(i -> Optional.of(Thread.currentThread().getName() + " " + i).ifPresent(System.out::println)));
        t1.start();
        try {
            //t1使用join后，t1先完成后才会执行主线程
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread is end");
    }
}
