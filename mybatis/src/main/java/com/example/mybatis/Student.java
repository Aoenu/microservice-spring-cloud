package com.example.mybatis;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/6/1.
 * @description
 */
public class Student {
    private Long studenId;
    private Long age;
    private String name;

    @Override
    public String toString() {
        return "Student:{studenId=" + studenId + ",name=" + name + ",age=" + age + "}";
    }

    public Long getStudenId() {
        return studenId;
    }

    public Student setStudenId(Long studenId) {
        this.studenId = studenId;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public Student setAge(Long age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
}
