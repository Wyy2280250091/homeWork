package com.example.demo.demo04;

import java.util.LinkedList;

/**
 * List 接口的链接列表实现。实现所有可选的列表操作，
 * 并且允许所有元素（包括 null）。
 * 除了实现 List 接口外，LinkedList 类还为在列表的开头及结尾 get、remove 和 insert 元素提供了统一的命名方法。
 * 这些操作允许将链接列表用作堆栈、队列或双端队列。
 *
 * 注意，此实现不是同步的
 *
 * 1、查询慢增删快
 * 2、大量操作首位方法
 *
 *
 * 常见方法
 *      public void addFirst(E e)将指定元素插入此列表的开头
 *      public void addLast(E e)将指定元素添加到此列表的结尾。
 *
 *      public E removeFirst()移除并返回此列表的第一个元素。
 *      public E removeLast()移除并返回此列表的最后一个元素。
 *
 *      public void clear()从此列表中移除所有元素。
 */
public class LinkedListDemo {
    public static void main(String[] args) {

        show();
    }

    private static void show() {
        //创建集合
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

    }
}
