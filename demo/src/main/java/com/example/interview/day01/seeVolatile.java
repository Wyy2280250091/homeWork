package com.example.interview.day01;

import java.util.concurrent.TimeUnit;

/**
 * volatile
 * 1、保证可见性
 * 2、不保证原子性
 * 3、禁止指令重拍
 * 可见性验证
 *
 */
class MyData {
  //  int number = 0;
    volatile int number = 0;//只要一个线程改动 那么所有线程都可见

    public  void  addTo(){
        this.number = 60;
    }
}

/**
 * 验证volatile的可见性
 * 1、假如等于0；没有添加关键字 没有可见性
 */
public class seeVolatile {
    public static void main(String[] args) {
        MyData myData = new MyData();//资源类

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo();
            System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);

        },"AAAA").start();

    //第二个线程main
        while (myData.number == 0){
//一直等待 退不出循环
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
