package com.example.demo.demo03;

import java.util.ArrayList;

/**
 * 增强for 底层是迭代器 使用的是for循环格式 简化书写
 * JDK1.5出现的新特性
 */
public class ForeachDemo {
    public static void main(String[] args) {
        demo01();
        demo02();
    }

    //增强for循环
    private static  void demo02(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.add("dddd");

        for(String s :list){
            System.out.println(s);
        };
    }

    private static void demo01() {
        int[] arr = {1,2,3,4,5};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
