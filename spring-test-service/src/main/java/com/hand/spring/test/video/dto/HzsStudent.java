package com.hand.spring.test.video.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/24.
 * @description
 */
@Table(name = "student")
public class HzsStudent {
    @Id
    @Column
    private int studentId;
    @Column
    private String name;
    @Column
    private int age;

    public int getStudentId() {
        return studentId;
    }

    public HzsStudent setStudentId(int studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public HzsStudent setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public HzsStudent setAge(int age) {
        this.age = age;
        return this;
    }
}
