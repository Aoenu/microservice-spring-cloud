package com.hand.spring.test.video.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/24.
 * @description
 */
@Table(name = "user_table")
public class HzsUser {
    @Id
    @Column
    private int userId;
    @Column
    private String userName;
    @Column
    private int age;

    public int getUserId() {
        return userId;
    }

    public HzsUser setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public HzsUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public HzsUser setAge(int age) {
        this.age = age;
        return this;
    }
}
