package com.xzq.thymeleaf7_2;

/**
 * @author:xzq
 * @Descripition:
 * @Date: Created in 15:13 2017/8/22
 * @Modified:
 */
public class Person {
    private  String name;
    private  Integer age;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
