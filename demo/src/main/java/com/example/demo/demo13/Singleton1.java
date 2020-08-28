package com.example.demo.demo13;

/**
 * 饿汉式：
 *      直接创建实例对象，不管是否需要
 *
 *      1、构造器私有化
 *      2、自行创建，并且提供静态变量
 *      3、向外提供
 *      4、强调单利 可以final修饰
 *      5、不存在线程安全问题
 *
 * 三种实现方式：
 *      1、直接实例化
 *      2、枚举式
 *      3、静态代码块饿汉式（适合复杂实例化）
 *
 *
 *
 *
 *
 * 懒汉式：
 *      1、构造器私有化
 *      2、用静态变量保存实例对象
 *      3、提供一个静态方法获取这个实例对象
 *
 */
public class Singleton1 {
 //  1、直接实例化
    private  static  final  Singleton1 INSSTANCE = new Singleton1();

    private  Singleton1(){

    }

}
