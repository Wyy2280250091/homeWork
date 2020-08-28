package com.example.demo.demo06;

public class ThreadDemo {
//单线程
    public static void main(String[] args) {
        Person p1 = new Person("小黑");
        p1.run();
      //  System.out.println(0/0);
        Person p2 = new Person("小白");
        p2.run();
    }
}
