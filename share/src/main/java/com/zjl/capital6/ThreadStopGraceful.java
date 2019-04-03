package com.zjl.capital6;

import java.util.concurrent.TimeUnit;

public class ThreadStopGraceful {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutdown();
    }

    static class Worker extends Thread {
        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {
                System.out.println("thread is working");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            this.start = false;
        }
    }
}
