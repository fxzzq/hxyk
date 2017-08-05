package com.xzq.demo.module;

public class Test {
    public static void main(String[] args) {
        //创建线程对象
        Thread t1 = new Thread(new myThread());
        Thread t2= new Thread(new myThread());
        t1.setName("我是线程1");
        t2.setName("我是线程2");
        t1.start();
        t2.start();

    }
}


