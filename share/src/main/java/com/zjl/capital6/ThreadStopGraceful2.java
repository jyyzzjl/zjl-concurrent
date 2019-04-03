package com.zjl.capital6;

import java.util.concurrent.TimeUnit;

public class ThreadStopGraceful2 {
    static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("thread is working");
                    TimeUnit.SECONDS.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("线程被打断");
                    break;
                }
            }
            System.out.println("线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        TimeUnit.SECONDS.sleep(5);
        worker.interrupt();
    }
}
