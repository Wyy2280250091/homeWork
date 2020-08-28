package com.example.interview.day01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile
 * 1、保证可见性
 * 2、不保证原子性
 * 3、禁止指令重拍
 * 不保证原子性验证
 *
 */

class MyData2{

    volatile int number = 0;

    public void addTo(){
        this.number = 60;
    }

    public /*synchronized 重量级*/  void  addPlus(){
        //多线程情况下不安全
        number ++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomoic(){
        //Atomically increments by one the current value.
        atomicInteger.getAndIncrement();
    }
}
public class actomicVolatile {
    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();//资源类

        for (int i = 1; i <= 20 ; i++) {
            new Thread(() ->{
                for (int j = 1; j <= 1000; j++) {
                    myData2.addPlus();
                    myData2.addAtomoic();
                }
            },String.valueOf(i)).start();

        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value:"+myData2.number);
        System.out.println(Thread.currentThread().getName()+"\t Atomic value:"+myData2.atomicInteger);


        //第二个线程main
        while (myData2.number == 0){
//一直等待 退不出循环
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
