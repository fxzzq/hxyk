package com.rico.demo.module1;

/**
 *
 * 构建单例对象
 * 1) 私有构造方法
 * 2) 保证一个对象一致存在JVM里面，直到程序运行结束
 * 3) 返回这个单例对象的引用给外部调用
 * Created by Rico on 2017/8/3.
 */
public class Person {

    //  静态变量的生命周期控制对象生命周期
   private static Person person = new Person();

//   public static int x = 10;

    public int x;

    /**
     * 访问修饰符：4种
     * 在Java中，当一个对象不被任何引用变量引用的时候，就是无效对象
     */
    private Person () {

    }

    public static Person getInstance() {
        return  person;
    }

}
