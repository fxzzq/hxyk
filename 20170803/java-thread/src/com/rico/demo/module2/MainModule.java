package com.rico.demo.module2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rico on 2017/8/3.
 */
public class MainModule {

    public static void main(String[] args) {

//        Thread thread = new Thread(new MyThread());
//        thread.start();


        // 创建Thread的匿名子类
        // 内部类
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "副线程运行。");
//            }
//        };
//        thread.start();

        // 局部内部类
//        class IThread extends  Thread {
//
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "副线程运行。");
//            }
//        }
//
//        Thread thread = new IThread();
//        thread.start();



        /// 创建Runnable接口的匿名实现类
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        thread.start();

//        class IThread implements Runnable {
//
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "副线程运行。");
//            }
//        }
//
//        Thread thread = new Thread(new IThread());
//        thread.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();

        //  lamda 表达式
//        new Thread(
//                () -> System.out.println("副线程运行")
//        ).start();

        List<String> names = new ArrayList<>();
        names.add("tom");
        names.add("jack");
        names.add("anna");
        names.add("lily");
        names.add("tiger");

        for (String str:names
             ) {
            System.out.println(str);
        }

//        Collections.sort(names);
//        System.out.println("-------------------");
//
//        for (String str:names
//                ) {
//            System.out.println(str);
//        }

//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return -o1.compareTo(o2);
//            }
//        });

        Collections.sort(names,
                ( a,  b) -> -a.compareTo(b)
                );

        System.out.println("-------------------");

        for (String str:names
                ) {
            System.out.println(str);
        }

    }
}
