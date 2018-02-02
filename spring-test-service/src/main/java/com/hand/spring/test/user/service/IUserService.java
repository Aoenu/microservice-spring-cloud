package com.hand.spring.test.user.service;

import com.hand.spring.test.user.dto.User;
import com.hand.spring.test.user.dto.UserInfo;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/31.
 * @description
 */
public interface IUserService {
    UserInfo validate(String username, String password);

    UserInfo findByName(String username);

    UserInfo updataPassword(User entity);
}
