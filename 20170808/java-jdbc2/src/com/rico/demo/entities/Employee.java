package com.rico.demo.entities;

/**
 * Created by Rico on 2017/8/8.
 */
public class Employee {

    private Long id;
    private String name;
    private Long fk_student;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFk_student() {
        return fk_student;
    }

    public void setFk_student(Long fk_student) {
        this.fk_student = fk_student;
    }
}
