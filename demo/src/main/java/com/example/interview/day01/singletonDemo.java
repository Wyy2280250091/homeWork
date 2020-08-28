package com.example.interview.day01;

/**
 * 验证单例模式的线程不安全
 */
public class singletonDemo {
    private static  singletonDemo  instance = null;
    private singletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法singletonDemo()");
    }

    public static singletonDemo getInstance(){

        if(instance == null){
            synchronized (singletonDemo.class){
                if(instance == null){
                    instance = new singletonDemo();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        //验证是否为同一个
//        System.out.println(singletonDemo.getInstance() == singletonDemo.instance);
//        System.out.println(singletonDemo.getInstance() == singletonDemo.instance);
//        System.out.println(singletonDemo.getInstance() == singletonDemo.instance);
        for (int i = 0; i < 10  ; i++) {

            new Thread(() -> {
                singletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
