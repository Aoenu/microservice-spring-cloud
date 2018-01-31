package com.hand.spring.test.user.mapper;

import com.hand.spring.test.user.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/31.
 * @description
 */
@Mapper
public interface UserMapper {

    User getUserByUsername(@Param("username") String username);

    void updataPassword(@Param("username") String username,@Param("password") String password);
}
