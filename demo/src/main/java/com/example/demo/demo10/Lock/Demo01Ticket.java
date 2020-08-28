package com.example.demo.demo10.Lock;

/**
 * 模拟卖票案例
 *
 *
 * 解决线程安全的同步代码块
 *      格式：
 *             synchronized(锁对象）｛
 *                  可能会出现的线程安全问题代码
 *             ｝
 *      PS：
 *          1、通过代码块中的锁对象，可以使用任意的对象
 *          2、但是必须保证多个线程使用的锁对象是同一个
 *          3、锁对象的作用：
 *              把同步代码块锁住
 *              只让一个线程执行
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
            //创建Thread类对象 构造方法中传递Runnable 接口的实现类对象
            Thread t0 = new Thread(run);
            Thread t1 = new Thread(run);
            Thread t2 = new Thread(run);
            t0.start();
            t1.start();
            t2.start();

    }
}
