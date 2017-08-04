package com.rico.demo.module;

/**
 * Created by Rico on 2017/8/3.
 */
public class MainModule {

    public static void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
//        System.out.println("--hello--");
//        hello();

        System.out.println(Thread.currentThread().getName() + " 启动。");

        // 创建副线程对象
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        // 调用线程的启动方法
        myThread.start();
        myThread1.start();

        System.out.println(Thread.currentThread().getName() + " 结束。");

    }

}
