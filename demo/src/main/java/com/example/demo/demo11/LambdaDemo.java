package com.example.demo.demo11;

/**
 * lambda表达式可以省略
 * 凡是根据上下文可以推导出来的都可以省略
 * 省略内容：
 *      1、（参数列表）：括号中的数据类型
 *      2、（参数列表）：如果参数只有一个 类型和（）都可以省略
 *      3、｛｝中的代码只有一行； 无论是否有返回值，都可以省略（｛｝，return ，分号）；
 *             必须一起省略
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {
        //使用匿名内部类方式 s实现多线程
        new Thread(){
            @Override
            public void run() {
                System.out.println("你好");
            }
        }.start();


        //使用Lambda方式 s实现多线程
        /**
         * Lambda标注格式：
         *      （参数列表）-> ｛重写的代码｝
         *      a、一些参数
         *      b、一个箭头
         *      c、一段代码
         */
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"新线程");
        }).start();


        //优化省略版本
        new Thread(()->
            System.out.println(Thread.currentThread().getName()+"新线程2")
        ).start();
    }
}
