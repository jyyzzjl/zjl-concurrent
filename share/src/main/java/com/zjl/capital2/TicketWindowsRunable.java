package com.zjl.capital2;

public class TicketWindowsRunable implements Runnable{
    private final static int MAX=50;
    private static int index=1;//设置为static，则几个线程共享index的值

    @Override
    public void run() {
        while(index<=MAX){
            System.out.println(Thread.currentThread()+" current index  is："+(index++));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
