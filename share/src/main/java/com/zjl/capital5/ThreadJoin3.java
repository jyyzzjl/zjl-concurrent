package com.zjl.capital5;

import java.util.concurrent.TimeUnit;

public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Capture("采集器1", 5));
        Thread t2 = new Thread(new Capture("采集器2", 10));
        Thread t3 = new Thread(new Capture("采集器3", 15));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}

class Capture implements Runnable {
    private String captureName;
    private int captureTime;

    Capture(String captureName, int captureTime) {
        this.captureName = captureName;
        this.captureTime = captureTime;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(captureTime);
            System.out.println(captureName + " is done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
