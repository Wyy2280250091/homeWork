package com.example.demo.demo04;

import java.util.HashSet;
import java.util.Iterator;

/**
 * set集合：
 *      一个不包含重复元素的 collection
 *      没有索引的collection集合
 *
 *HashSet
 *      此类实现 Set 接口，由哈希表（实际上是一个 HashMap 实例）支持。
 *      它不保证 set 的迭代顺序；
 *      特别是它不保证该顺序恒久不变。此类允许使用 null 元素。
 *
 *      无序
 *      没有索引
 *      不重复
 *      底层是hashmap
 *注意，此实现不是同步的。
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        //添加元素
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("2");
        set.add("1");
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            Object n = iterator.next();
            System.out.println(n);
        }
        System.out.println("+++++++++++++++");
        //增强for
        for (Object o : set) {
            System.out.println(o);
            
        }
    }
}
