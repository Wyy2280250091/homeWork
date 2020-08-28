package com.example.demo.demo11;

/**
 *
 * 等待唤醒案例
 *      创建俩个线程 生产者 消费者
 *      消费者：waiting
 *      生产者：notify唤醒消费者
 *  PS：
 *      生产者消费者必须使用同步代码块包裹
 *      保证等待和唤醒只有一个在执行
 *      只有锁对象才可以调用notify方法
 *
 *      public final void notify()
 *          唤醒在此对象监视器上等待的单个线程。
 *          如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。
 *          选择是任意性的，并在对实现做出决定时发生。
 *          线程通过调用其中一个 wait 方法，在对象的监视器上等待。
 *      public final void wait()
 *         throws InterruptedException在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
 *         换句话说，此方法的行为就好像它仅执行 wait(0) 调用一样。
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        //创建锁对象
        Object obj = new Object();
        //创建消费者
        new Thread(){
            @Override
            public void run() {
                //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (obj){
                    System.out.println("告知老板要的包子种类和数量");
                    //调用wait方法放弃CPU的执行，进入到WAITING状态（无线等待）
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒后执行的代码
                    System.out.println("开始消费");
                }
            }
        }.start();

        //创建生产者
        new Thread(){
            @Override
            public void run() {
                //生产时间
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (obj){
                    System.out.println("告知消费者已经生产好了");
                    obj.notify();
                }
            }
        }.start();

    }
}
