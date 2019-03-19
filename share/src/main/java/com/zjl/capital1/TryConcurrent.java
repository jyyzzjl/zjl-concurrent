package com.zjl.capital1;

import java.util.concurrent.TimeUnit;


public class TryConcurrent {
    public static void main(String[] args) {
//        readFromDatabase();//读取数据
//        writeToFile();//写入文件
        //通过新建线程的方式实现
        Thread t1=new Thread("write-thread"){
            @Override
            public void run() {
                writeToFile();
            }
        };
        //通过java1.8最新的lamda表达式创建线程
        new Thread(TryConcurrent::readFromDatabase).start();
        t1.start();
    }

    private static void writeToFile() {
        try {
            println("begin write data to file");
            TimeUnit.SECONDS.sleep(2);
            println("end write data to file");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readFromDatabase() {
        try {
            println("begin read data from database");
            TimeUnit.SECONDS.sleep(2);
            println("end read data from database");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void println(String string){
        System.out.println(string);
    }
}
