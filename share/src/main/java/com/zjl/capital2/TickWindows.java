package com.zjl.capital2;

public class TickWindows extends Thread{
    private final static int MAX=50;
    private static int index=1;//设置为static，则几个线程共享index的值
    private String name;

    TickWindows(String name){
        this.name=name;
    }
    @Override
    public void run() {
        synchronized (TickWindows.class){//如果此处使用synchronized进行同步，过程中锁不会释放，
            while(index<=MAX){
                System.out.println(this.name+" current index is："+(index++));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
