package com.xzq.firstspringboot2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:xzq
 * @Descripition:
 * @Date: Created in 23:22 2017/8/21
 * @Modified:
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {

    private  String name;
    private  Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
