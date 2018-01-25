package com.hand.spring.test.redis.dto;

import java.io.Serializable;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/25.
 * @description
 */
public class RedisUser implements Serializable{
    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public RedisUser(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public RedisUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public RedisUser setAge(Integer age) {
        this.age = age;
        return this;
    }
}
