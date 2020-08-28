package com.example.demo.demo13;

/**
 * 饿汉式：
 * 直接创建实例对象，不管是否需要
 * <p>
 * 1、构造器私有化
 * 2、自行创建，并且提供静态变量
 * 3、向外提供
 * 4、强调单利 可以final修饰
 * 5、不存在线程安全问题
 * <p>
 * 三种实现方式：
 * 1、直接实例化
 * 2、枚举式
 * 3、静态代码块饿汉式（适合复杂实例化）
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 懒汉式：
 * 1、构造器私有化
 * 2、用静态变量保存实例对象
 * 3、提供一个静态方法获取这个实例对象
 */
public class Singleton5 {
    //饿汉式2 线程安全 synchronized
    private static Singleton5 instance;

    private Singleton5() {

    }

    private static Singleton5 getInstance() {

        if (instance == null) {//性能优化
            synchronized (Singleton5.class) {//线程安全
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}