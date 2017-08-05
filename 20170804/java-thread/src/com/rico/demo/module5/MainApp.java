package com.rico.demo.module5;

/**
 * Created by Rico on 2017/8/4.
 */
public class MainApp implements  Runnable {

    private int a = 1;

    @Override
    public synchronized void  run() {

//        for(int i = 0; i < 100; i++) {
//            synchronized (this) {
//                a += i;
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                a -= i;
//                System.out.println(Thread.currentThread().getName() + " a = " + a);
//            }
//        }
//        synchronized (this) {
//            for(int i = 0; i < 100; i++) {
//                    a += i;
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    a -= i;
//                    System.out.println(Thread.currentThread().getName() + " a = " + a);
//
//            }
//        }

        for(int i = 0; i < 100; i++) {
                    a += i;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a -= i;
                    System.out.println(Thread.currentThread().getName() + " a = " + a);

            }



    }

    public static void main(String[] args) {

        MainApp mainApp = new MainApp();
        Thread t1 = new Thread(mainApp);
        Thread t2 = new Thread(mainApp);
        t1.start();
        t2.start();


//        Student student = new Student("hello");

    }
}
