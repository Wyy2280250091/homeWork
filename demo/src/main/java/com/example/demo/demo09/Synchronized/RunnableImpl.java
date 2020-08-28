package com.example.demo.demo09.Synchronized;

/*
 * 解决线程安全的同步代码块
 *      格式：
 *             synchronized(锁对象）｛
 *                  可能会出现的线程安全问题代码
 *             ｝
 * *      PS：
 *          1、通过代码块中的锁对象，可以使用任意的对象
 *          2、但是必须保证多个线程使用的锁对象是同一个
 *          3、锁对象的作用：
 *              把同步代码块锁住
 *              只让一个线程执行
 *             ---------------------------------
 *  解决线程安全第二种方法：
 *          同步方法
 *
 *          使用步骤：
 *                  1、把访问共享数据代码抽取出来 放到一个方法中
 *                  2、在方法中添加sychronize修饰符
 *          格式：
 *          public synchronized void AA(String s){
 *          把访问共享数据代码抽取出来
 *          }
 *-
 *          静态方法
 *          格式：
 *              public static synchronized void BB(){
 *                  共享数据代码块
 *              }
 *

 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享票源
    private static int  ticket = 100;

    //创建一个锁对象
    Object obj = new Object();

    @Override
    public void run() {
        //使用死循环 一直卖票
        while (true) {
            //同步代码块
            synchronized (obj) {
                //先判断票是否存在
//                if (ticket > 0) {
//                    //提高安全问题概率
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    //票存在
//                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
//                    ticket--;
//                }

                //payTicket();
                payTicketStatic();
            }
        }
    }

    /**
     * 定义哦同步方法
     *
     */
    public synchronized void payTicket(){
        //先判断票是否存在
        if (ticket > 0) {
            //提高安全问题概率
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //票存在
            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
            ticket--;
        }
    }

    /**
     * 静态同步方法
     * 锁对象不是this
     * this是创建对象后产生的 静态方法优于对象
     * 静态方法的锁对象是本类的class属性
     */
    public static synchronized void payTicketStatic(){
        //先判断票是否存在
        if (ticket > 0) {
            //提高安全问题概率
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //票存在
            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
            ticket--;
        }
    }
}
