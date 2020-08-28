package com.example.demo.demo06;

/**
 * 匿名内部类方式创建线程
 *
 * 格式：
 *      new 父类、接口（）｛
 *          重写父类/接口方法
 *      ｝；
 *
 */
public class Thread03 {
    public static void main(String[] args) {
        //线程父类是Thread
        //new MyThrea().start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+i);
                }
            }
        }.start();


        //线程的接口Runnable
        //
    }
}
