package com.example.demo.demo04;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 有序的 collection（也称为序列）。此接口的用户可以对列表中每个元素的插入位置进行精确地控制。用户可以根据元素的整数索引
 * 在列表中的位置）访问元素，并搜索列表中的元素。
 * 1、有序
 * 2、有索引
 * 3、允许存储重复元素
 *
 *
 * 常见方法
 *      boolean add(E e)向列表的尾部添加指定的元素（可选操作）。
 *      E get(int index)返回列表中指定位置的元素。
 *      E set(int index,
 *      E element)用指定元素替换列表中指定位置的元素（可选操作）。
 *      E remove(int index)移除列表中指定位置的元素（可选操作）。将所有的后续元素向左移动（将其索引减 1）。返回从列表中移除的元素。
 */
public class ListDemo {
    public static void main(String[] args) {

        //创建集合
        List<String> list = new ArrayList<>();
        //add
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        //打印
        System.out.println(list);
//[a, b, c, d, a]

        list.add(3,"aaa");
//[a, b, c, aaa, d, a]
        System.out.println(list);

        String removeE = list.remove(2);
        System.out.println("被移除的元素："+removeE);
        System.out.println(list);
        //被移除的元素：c
        //[a, b, aaa, d, a]

        //替换 set
        String setE = list.set(4,"A");
        System.out.println("被替换的元素："+ setE);
        System.out.println(list);
        //被替换的元素：a
        //[a, b, aaa, d, A]


        //遍历
        for(int i = 0;i<list.size(); i++){
            //get
            String s = list.get(i);
            System.out.println(s);
        }

        System.out.println("++++++++++++++++++++++++");
        //迭代器遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("++++++++++++++++++++++++");
        //增强for
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("++++++++++++++++++++++++");

    }

}
