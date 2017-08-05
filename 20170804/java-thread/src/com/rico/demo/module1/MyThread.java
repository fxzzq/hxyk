package com.rico.demo.module1;

import java.util.Calendar;

/**
 * Created by Rico on 2017/8/3.
 */
public class MyThread extends  Thread {

    @Override
    public void run() {
        Person person = Person.getInstance();
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " x = " + person.x++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
