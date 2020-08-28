package com.example.demo.demo04;

/**
 * 对象的逻辑地址
 * int hashCode()
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        //person类继承Object类

        Person p1 = new Person();
        int h1 = p1.hashCode();
        //Person@5caf905d
        //1555009629
        System.out.println(p1);
        System.out.println(h1);

        Person p2 = new Person();
        int h2 = p2.hashCode();
        //Person@27716f4
        //41359092
        System.out.println(p2);
        System.out.println(h2);

        System.out.println(p1==p2);


        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
    }
}
