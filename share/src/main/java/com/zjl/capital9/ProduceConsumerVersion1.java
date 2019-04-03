package com.zjl.capital9;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ProduceConsumerVersion1 {
    private final Object LOCK = new Object();
    private volatile boolean produced = false;
    private int i = 0;

    private void produce() {
        synchronized (LOCK) {
            while (produced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("p1->" + (++i));
            produced = !produced;
            LOCK.notifyAll();
        }
    }

    private void consumer() {
        synchronized (LOCK) {
            while (!produced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C1->" + i);
            produced = !produced;
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion1 produceConsumerVersion1 = new ProduceConsumerVersion1();

        Stream.of("p1", "p2").forEach(n -> {
            new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    produceConsumerVersion1.produce();
                }
            }, n).start();
        });
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                produceConsumerVersion1.consumer();
            }
        }).start();
    }
}
