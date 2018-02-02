package com.hand.pojo;

import java.io.Serializable;


/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/31.
 * @description
 */
public class UserInfo implements Serializable{

    public String id;
    public String userName;
    public String passWord;
    public String userRole;
    private String description;

    public String getId() {
        return id;
    }

    public UserInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public UserInfo setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public UserInfo setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserInfo() {
    }

    public UserInfo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
