package com.xzq.demo.module1;

public class Test {
    public static void main(String[] args) {
        Machine t1 = new Machine();
        Machine t2 = new Machine();
        t1.setName("t1");
        t2.setName("t2");
        Thread mainThread = Thread.currentThread();
        System.out.println("主线程的优先级：" + mainThread.getPriority());
        System.out.println("t1线程的优先级：" + t1.getPriority());
        System.out.println("t2线程的优先级：" + t2.getPriority());

        t1.setPriority(Thread.MIN_PRIORITY);
       t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

    }
}
