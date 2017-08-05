package com.rico.demo.module3;

/**
 * Created by Rico on 2017/8/4.
 */
public class MT extends Thread {

    @Override
    public void run() {
        System.out.println("线程开始");
        try {
            System.out.println("睡眠开始");
            Thread.sleep(10000);
            System.out.println("睡眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束");
    }

    public static void main(String[] args) {
//        System.out.println("主线程开始");
//        MT t = new MT();
//        t.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t.interrupt();
//        System.out.println("主程结束");


        Thread thread = new Thread(
                () -> {
                    for(int i = 0; i <10; i++) {
                        System.out.println(Thread.currentThread().getName() + " i = " + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        System.out.println("Main线程开始");
        thread.start();
        try {
//            thread.join();
            thread.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main线程结束");
    }
}
