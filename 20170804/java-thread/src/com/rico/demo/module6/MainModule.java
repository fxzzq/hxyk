package com.rico.demo.module6;

/**
 * Created by Rico on 2017/8/4.
 *
 * 解决线程同步问题，有几种方式：
 * 1） 空间换时间
 * 2）时间换空间
 */
public class MainModule extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            int x = Counter.getCount();
            System.out.println(
                    this.getName() + " : " + x);
            Counter.setCount(x += 2);

        }
    }

    public static void main(String[] args) {
        MainModule mainModule1 = new MainModule();
        MainModule mainModule2 = new MainModule();
        mainModule1.start();
        mainModule2.start();
    }
}


class Counter {

    private static int count = 5;

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return new Integer(count);
        }
    };

    public static int getCount () {
        return threadLocal.get();
    }

    public static void setCount(int count) {
        threadLocal.set(count);
    }

}