package com.example.interview.day02;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 */

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User u1 = new User("张三",22);
        User u2 = new User("李四",25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(u1);
        System.out.println(
                atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get().toString());

        System.out.println(
                atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get().toString());
    }
}
