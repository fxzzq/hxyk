package com.rico.demo.module4;

/**
 * Created by Rico on 2017/8/4.
 */
public class MainModule {

    public static void main(String[] args) {

        System.out.println("Main = " + Thread.currentThread().isDaemon());

        Thread thread = new Thread() {

            private int a;

            @Override
            public synchronized void start() {
                super.start();

                Thread daemon = new Thread() {


                    @Override
                    public void run() {
                        while(true) {
                            a = 0;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                // 设置后台线程 -> 谁执行的这句代码，后台线程和他绑定
                daemon.setDaemon(true);
                System.out.println("Daemon = " + daemon.isDaemon());
                daemon.start();
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
        System.out.println("Thread = "  +  thread.isDaemon());
        thread.start();

    }
}
