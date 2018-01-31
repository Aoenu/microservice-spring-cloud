package com.hand.spring.test.user.service.impl;

import com.hand.security.api.vo.user.UserInfo;
import com.hand.spring.test.constant.UserConstant;
import com.hand.spring.test.user.dto.User;
import com.hand.spring.test.user.mapper.UserMapper;
import com.hand.spring.test.user.service.IUserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/31.
 * @description
 */
@Service
public class UserServierImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private IUserService service;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);



    @Override
    public UserInfo validate(String username, String password) {
        UserInfo info = new UserInfo();
        User user = mapper.getUserByUsername(username);
        if (encoder.matches(password, user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId().toString())
                    .setDescription(user.getDescription())
                    .setPassWord(password)
                    .setUserName(user.getUsername())
                    .setUserRole(user.getUserrole());
        }
        return info;
    }

    @Override
    public UserInfo findByName(String username) {
        User user = mapper.getUserByUsername(username);
        return new UserInfo().setId(user.getId()+"")
                .setDescription(user.getDescription())
                .setPassWord(user.getPassword())
                .setUserName(user.getUsername())
                .setUserRole(user.getUserrole());
    }

    @Override
    public UserInfo updataPassword(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        mapper.updataPassword(entity.getUsername(),entity.getPassword());
        return service.findByName(entity.getUsername());
    }
}
