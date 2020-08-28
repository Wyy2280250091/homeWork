package com.example.interview.day02;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


public class ContainerNotSafeDemo {
    public static void main(String[] args) {

    }
    /**
     * 验证Arraylist 线程不安全实例
     *java.util.ConcurrentModificationException
     *     boolean add(E e);添加方法没有加锁
     */
    public static void listNoSafe() {
        //List<String> list = new ArrayList<>();
        // List<String> list = new Vector<>(); new ArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        /**
         * 1、故障
         *  java.util.ConcurrentModificationException
         * 2、原因
         *      并发修改导致，例子：花名册签名
         * 3、解决方案
         *          new Vector<>()
         *         Collections.synchronizedList(new ArrayList<>());
         *         java.util.concurrent.CopyOnWriteArrayList;
         * 4、优化建议
         */
    }
    public static void setNotSafe(){
        //Set<String> set = new HashSet<>();
        //java.util.ConcurrentModificationException
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>(new HashSet<>());

        for (int i = 0; i < 30 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
    public static void mapNotSafe(){
        //Map<String ,String> map = new HashMap<>();
        //Map<String ,String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String ,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(
                        Thread.currentThread().getName(),
                        UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}