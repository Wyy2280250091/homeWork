package com.example.demo.demo03;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 *
 * public interface Iterator<E>对 collection 进行迭代的迭代器。迭代器取代了 Java Collections Framework 中的 Enumeration。迭代器与枚举有两点不同：
 *
 * 迭代器允许调用者利用定义良好的语义在迭代期间从迭代器所指向的 collection 移除元素。
 * 方法名称得到了改进。
 *
 *
 * boolean hasNext()如果仍有元素可以迭代，则返回 true。（换句话说，如果 next 返回了元素而不是抛出异常，则返回 true）。
 *指针从-1开始
 *
 * 返回：
 * 如果迭代器具有多个元素，则返回 true。
 *
 *
 *
 * void remove()从迭代器指向的 collection 中移除迭代器返回的最后一个元素（可选操作）。每次调用 next 只能调用一次此方法。如果进行迭代时用调用此方法之外的其他方式修改了该迭代器所指向的 collection，则迭代器的行为是不确定的。
 */
public class IteratorDemo {

    public static void main(String[] args) {
        //创建集合

        Collection<String> coll = new ArrayList<>();
        //添加元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("乔丹");
        coll.add("艾弗森");
        coll.add("麦迪");

        /**
         * 1使用集合中的的Iterator()获取迭代器的实现类对象 使用接口接收多态
         * 泛型
         */
//          多态  接口          实现类
        Iterator<String> it = coll.iterator();

        while(it.hasNext()){
            String e = it.next();
            System.out.println(e);
        }


/**
 * 没有元素则抛出这个异常
 * false
 * Exception in thread "main" java.util.NoSuchElementException
 * 	at java.util.ArrayListDemo$Itr.next(ArrayListDemo.java:862)
 * 	at IteratorDemo.main(IteratorDemo.java:54)
 */
        //判断有没有下一个元素
        boolean b = it.hasNext();
        System.out.println(b);
        //取出下一个元素
        String s = it.next();
        System.out.println(s);

    }
}
