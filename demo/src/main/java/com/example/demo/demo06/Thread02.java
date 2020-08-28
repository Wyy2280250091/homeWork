package com.example.demo.demo06;

/**
 *创建线程第二章方法 Runnable
 * public interface RunnableRunnable
 * 接口应该由那些打算通过某一线程执行其实例的类来实现。
 * 类必须定义一个称为 run 的无参数方法。
 *
 * 实现步骤：
 *      1、创建实现类
 *      2、重写Runnable run 方法
 *      3、创建Runnable接口实现类对象
 *      4、创建Thread类对象，构造方法中传递Runnable接口的实现类对象
 *      5、调用Thread 方法中start方法 开启新线程执行run方法
 */
public class Thread02 {
    public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();

        Thread t = new Thread(run);
        t.start();
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"   "+i);
        }
    }
}
