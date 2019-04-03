package com.zjl.capital6;

import java.util.concurrent.TimeUnit;

public class ThreadService {
    private Thread executeThread;
    private boolean finished = false;

    private void execute(Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    private void shutdown(long millis) throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if (System.currentTimeMillis() - currentTime > millis) {
                System.out.println("thread is ex timeb");
                executeThread.interrupt();
                break;
            }
            TimeUnit.MILLISECONDS.sleep(10);
        }

    }
}
