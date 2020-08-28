package com.example.demo.demo03;

import java.util.ArrayList;

/**
 * public static <T> void sort(List<T> list,
 *                             Comparator<? super T> c)
 * 根据指定比较器产生的顺序对指定列表进行排序。
 */
public class Collections {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);


    }

    private static void sort(ArrayList<Integer> list, Comparable<Integer> integerComparable) {
    }
}
