package com.example.interview.day03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * AAA	 come in
 * BBBB	 come in
 * AAA	 invoked myUnLock
 * BBBB	 invoked myUnLock
 * 获取锁的线程不好立即阻塞，而是采用循环的方式去尝试获取锁
 */
public class SpinLockDemo {
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.mylock();
            try {
                 TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"AAA").start();

        try {
             TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        new Thread(() -> {
            spinLockDemo.mylock();
            spinLockDemo.myUnlock();
        },"BBBB").start();
    }
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        while (!atomicReference.compareAndSet(null,thread)){
            //循环判断是否为null 判断其他线程是否用完
        }
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnLock");
    }
}
