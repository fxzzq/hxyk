package com.rico.demo.module1;

/**
 * Created by Rico on 2017/8/3.
 */
public class MainModule {

    private int x;


    public static void main(String[] args) {


//        MainModule mainModule = new MainModule();
//        MainModule mainModule1 = mainModule;
//        mainModule = null;

//        mainModule = new MainModule();

//        System.out.println(Person.x);

//        Person p1 = Person.getInstance();
//        Person p2 = Person.getInstance();
//        System.out.println(p1.hashCode());
//        System.out.println(p2.hashCode());

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();

        Thread thread = new MyThread();


    }
}
