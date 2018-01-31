package com.hand.service;

import com.hand.security.api.vo.user.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Levin
 * @date 2017-08-15.
 */
@FeignClient(value = "spring-test-service")
public interface UserInfoService {
    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
    UserInfo validate(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "/user/findByName", method = RequestMethod.POST)
    UserInfo findByName(@RequestParam("username") String username);

//    public UserInfo findByName(String username) {
//        //TODO 该处只是为了模拟查询数据库
//        if (username.equals("member")) {
//            return new UserInfo("member", "member");
//        }
//        return new UserInfo("test", "test");
//    }
}
