package com.example.demo.demo11;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建新的线程");
    }
}
