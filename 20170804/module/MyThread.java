package com.xzq.demo.module;

//实现Runnable接口
class myThread implements Runnable{
    @Override
    public void run(){
        for (int i=1;i<=20;i++){
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程名称："+Thread.currentThread().getName()+"次数："+i);
        }

    }
}