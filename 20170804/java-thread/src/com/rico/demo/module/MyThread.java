package com.rico.demo.module;

/**
 * Created by Rico on 2017/8/3.
 */
public class MyThread extends  Thread {

    /**
     * 副线程（用户自定义线程）
     * 中需要运行的代码
     */
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +  " i = " + i);

        }
    }

    @Override
    public synchronized void start() {
        // 不能取消
        super.start();

        System.out.println("副线程启动");
    }
}
