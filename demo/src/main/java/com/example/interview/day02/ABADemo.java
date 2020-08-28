package com.example.interview.day02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 时间戳  版本号 解决aba问题
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        new Thread(() -> {
            //ABA 操作
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(() -> {
            try {
                //暂停一秒钟保证上面完成ABA操作
                 TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
            System.out.println(
                    atomicReference.compareAndSet(100,2020)
                            + "\t" +atomicReference.get().toString());
        },"t2").start();

//延长保证ABA实现
        try {
             TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        System.out.println("=========ABA结局办法=============");
        new Thread(() -> {
           // int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+ "\t 第一次打印的版本号"+ atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(
                    100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+ "\t 第二次打印的版本号"+ atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(
                    101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+ "\t 第三次打印的版本号"+ atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(() -> {
           int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+ "\t 第一次打印的版本号"+ stamp);
            try {
                //暂停三秒钟保证t3 完成ABA操作
                 TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(
                    100, 2020,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);

            System.out.println(
                    Thread.currentThread().getName()
                            +"\t 最新版本号的版本号:"+ atomicStampedReference.getStamp()
                            +"\t 是否修改成功"+result);

        },"t4").start();







    }
}
