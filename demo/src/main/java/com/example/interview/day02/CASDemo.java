package com.example.interview.day02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 比较交换CompareAndSet
 * 某个时刻取出数据并替换 但是会因为时间差 导致ABA问题
 * 解决办法：时间戳生成版本号
 *
 * 缺点：
 * 1、aba问题｛
 *      主内存：A
 *      线程1：A 快
 *      线程2：A慢
 *      1->A->b->a
 *      2->A=A
 *      狸猫换太子
 *      线程1改了俩次 改回来了
 *      线程2 没有发现改动迹象
 *      ｝
 * 2、循环操作CPU高占用
 * 3、只能保证单个原子类
 */
public class CASDemo {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2020)+"\t current data:" +atomicInteger);
        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current data:" +atomicInteger);
    }
}
