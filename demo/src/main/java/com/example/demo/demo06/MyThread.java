package com.example.demo.demo06;

public class MyThread extends  Thread {

    @Override
    public void run() {
        //for (int i = 0; i <20; i++) {
        //    System.out.println("run"+i);
            //获取线程名称
            System.out.println(getName());

        Thread t = Thread.currentThread();
        System.out.println(t);
        // }
    }

}
