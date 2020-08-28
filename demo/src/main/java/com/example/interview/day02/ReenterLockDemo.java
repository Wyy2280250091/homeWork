package com.example.interview.day02;

class Phone{
    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoked sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoked sendEmail()");
    }
}
/**
 *
 * 可重入锁（递归锁）
 * 指的是同一线程在外层函数获得锁之后，内层递归函数仍然能获取改锁的代码，
 * 在同一个线程的外层方法获取的方法，在进入内层方法会自动获取锁
 *
 * 也就是说：线程可以进入任何一个它已经拥有的锁所同步着的代码块
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
