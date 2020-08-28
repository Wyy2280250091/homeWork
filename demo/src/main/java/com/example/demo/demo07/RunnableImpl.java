package com.example.demo.demo07;

public class  RunnableImpl implements Runnable {
    //定义一个多线程共享票源
    private int ticket = 100;

    @Override
    public void run() {
        //使用死循环 一直卖票
        while (true){
            //先判断票是否存在
            if (ticket>0){
                //提高安全问题概率
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //票存在
                System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                ticket--;
            }
        }
    }
}
