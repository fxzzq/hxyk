package com.rico.demo.module3;

/**
 * Created by Rico on 2017/8/4.
 */
public class Machine extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }

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

        System.out.println("t1线程的优先级：" + t1.getPriority());
        System.out.println("t2线程的优先级：" + t2.getPriority());

        t1.start();
        t2.start();



    }
}
