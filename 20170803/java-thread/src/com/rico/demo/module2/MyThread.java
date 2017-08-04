package com.rico.demo.module2;

/**
 * Created by Rico on 2017/8/3.
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "副线程运行。");
    }
}
