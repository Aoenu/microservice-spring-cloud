package com.hand.pojo.enums;

/**
 * @author Levin
 * @date 2017-08-15.
 */
public enum RoleEnum {
    ADMIN("ADMIN"),
    MEMBER("MEMBER"),
    TEST("TEST");

    private String desc;
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    RoleEnum(String desc) {
        this.desc = desc;
    }
}
