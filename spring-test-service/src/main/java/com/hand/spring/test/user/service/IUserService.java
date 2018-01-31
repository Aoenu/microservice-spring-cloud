package com.hand.spring.test.user.service;

import com.hand.security.api.vo.user.UserInfo;
import com.hand.spring.test.user.dto.User;

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
