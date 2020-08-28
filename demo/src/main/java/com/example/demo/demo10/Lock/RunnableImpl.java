package com.example.demo.demo10.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
------------------------------------------------
        第三种方法
        lock锁
java.util.concurrent.locks
接口 Lock

        void lock()获取锁。
        如果锁不可用，出于线程调度目的，将禁用当前线程，并且在获得锁之前，该线程将一直处于休眠状态
*
          unlock
           void unlock()释放锁。
*
*         使用步骤：
*               1、在成员位置创建一个ReentrantLock对象
*               2、在可能出现安全问题的代码前调用lock（）方法获取锁
*               3、在可能出现安全问题的代码后调用unlock()释放锁


 */
public class RunnableImpl implements Runnable {
    //定义一个多线程共享票源
    private int ticket = 10;

    //在成员位置创建一个ReentrantLock 对象
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        //使用死循环 一直卖票
        while (true){
            l.lock();
            //先判断票是否存在
            if (ticket>0){
                try {
                    //提高安全问题概率
                    Thread.sleep(10);
                    //票存在
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    l.unlock();
                }
            }
        }
    }
}
