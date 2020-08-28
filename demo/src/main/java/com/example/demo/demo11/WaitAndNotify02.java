package com.example.demo.demo11;

/**
 * 进入到TimeWaiting(计时等待)有俩种方式
 * 1、使用sleep（long m）方法在毫秒值结束后线程睡醒进入到Runable/Blocked状态
 * 2、使用wait(long m) 方法在毫秒值结束后没有被唤醒就自动醒来
 * <p>
 * 唤醒方法：
 * 1、 void notify()
 * 唤醒在此对象监视器上等待的单个线程。
 * 2、 void notifyAll()
 * 唤醒在此对象监视器上等待的所有线程。
 */
public class WaitAndNotify02 {
    public static void main(String[] args) {
        //创建锁对象
        Object obj = new Object();
        //创建消费者1
        new Thread() {
            @Override
            public void run() {
                //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (obj) {
                    System.out.println("消费者1告知老板要的包子种类和数量");
                    //调用wait方法放弃CPU的执行，进入到WAITING状态（无线等待）
                    try {
                        // 使用wait(long m) 方法在毫秒值结束后没有被唤醒就自动醒来
                        obj.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒后执行的代码
                    System.out.println("消费者1开始消费");
                    System.out.println("-------------------------------");
                }
            }
        }.start();


        //创建消费者2
        new Thread() {
            @Override
            public void run() {
                //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (obj) {
                    System.out.println("消费者2告知老板要的包子种类和数量");
                    //调用wait方法放弃CPU的执行，进入到WAITING状态（无线等待）
                    try {
                        // 使用wait(long m) 方法在毫秒值结束后没有被唤醒就自动醒来
                        obj.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒后执行的代码
                    System.out.println("消费者2开始消费");
                    System.out.println("-------------------------------");
                }
            }
        }.start();


        //创建生产者
        new Thread() {
            @Override
            public void run() {
                //生产时间
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (obj) {
                    System.out.println("告知消费者已经生产好了");
                    obj.notifyAll();
                }
            }
        }.start();
    }
}
