package com.rico.demo.module4;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Rico on 2017/8/4.
 */
public class MainApp {

    public static void main(String[] args) {

        Thread thread = new Thread() {

            private int a;

            @Override
            public synchronized void start() {
                super.start();

                Timer timer = new Timer(true);

                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        a = 0;
                    }
                };

                timer.schedule(timerTask, 0, 1000);

            }

            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    a++;
                    System.out.println(Thread.currentThread().getId() + " a = " + a);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

     thread.start();
    }



}
