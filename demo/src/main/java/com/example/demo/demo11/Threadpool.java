package com.example.demo.demo11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池
 */
public class Threadpool {
    /**
     * 1、创建工程类
     * 2、重写runnable
     * 3.submit开启线程
     * 4、shutdown 销毁线程池
     *
     * 线程一直开启 用完后自动归还
     */
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(new RunnableImpl());//pool-1-thread-1创建新的线程
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());

        es.shutdown();
        /**
         * java.util.concurrent.RejectedExecutionException hreadPoolExecutor@452b3a41[Shutting down
         */
        es.submit(new RunnableImpl());
    }
}
