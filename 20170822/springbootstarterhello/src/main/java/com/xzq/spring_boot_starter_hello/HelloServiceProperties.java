package com.xzq.spring_boot_starter_hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author:xzq
 * @Descripition:
 * @Date: Created in 11:05 2017/8/22
 * @Modified:
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private  static  final String MSG="World";

    private  String msg=MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
