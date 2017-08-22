package com.xzq.spring_boot_starter_hello;

/**
 * @author:xzq
 * @Descripition:
 * @Date: Created in 11:07 2017/8/22
 * @Modified:
 */
public class HelloService {

    private  String msg;

    public  String sayhello(){

        return  "Hello"+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
