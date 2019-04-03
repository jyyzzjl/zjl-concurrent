package com.zjl.capital7;

import java.util.concurrent.TimeUnit;

public class TicketWindowRunable implements Runnable {
    private final int MAX = 500;
    private static int index = 0;
    private final Object MONITOR = new Object();

    @Override
    public void run() {
        synchronized (MONITOR) {
            while (index < MAX) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is running " + index++);
            }
        }
    }

    public static void main(String[] args) {
        Thread window1 = new Thread(new TicketWindowRunable());
        Thread window2 = new Thread(new TicketWindowRunable());
        Thread window3 = new Thread(new TicketWindowRunable());
        window1.start();
        window2.start();
        window3.start();

    }
}
