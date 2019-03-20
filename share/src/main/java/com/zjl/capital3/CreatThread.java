package com.zjl.capital3;

import java.util.concurrent.TimeUnit;

public class CreatThread {
    public static void main(String[] args) throws Error {
        int counter = 0;
        counter++;
        for(int i=0;i<Integer.MAX_VALUE;i++){
            //创建一个线程并执行
            new Thread(CreatThread::run).start();
        }
        System.out.println("Total created thread nums is==>"+counter);
    }

    private static void run() {
        byte[] date = new byte[1024 * 1024];
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
