package com.example.demo.demo06;

import javax.annotation.security.RunAs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建多线程第一种方式
 * 实现步骤：
 *      1、创建一个Thread子类
 *      2、重写run方法
 *      3、创建子类对象
 *      4、调用start方法
 *          public void start()使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
 *          结果是两个线程并发地运行；当前线程（从调用返回给 start 方法）和另一个线程（执行其 run 方法）。
 *          多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
 *   抢占式调度 随机打印
 */
public class Thread01 {
    public static void main(String[] args) {

        MyThread mt = new MyThread();
        mt.start();
        //mt.run();
//Thread-0
//Thread[Thread-0,5,main] 线程名称 优先级
//        for (int i = 0; i <20 ; i++) {
//            System.out.println("main:"+i);
//        }

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("你好");
//            }
//        };
//
        //lamdba 函数
//        Runnable runnable2=()->System.out.println("Running from Lambda");
    }
}
