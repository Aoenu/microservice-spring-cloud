package com.hand.spring.test.user.controller;

import com.hand.spring.test.user.dto.User;
import com.hand.spring.test.user.dto.UserInfo;
import com.hand.spring.test.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/31.
 * @description
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/updataPassword", method = RequestMethod.POST)
    public @ResponseBody
    UserInfo updataPassword(@RequestBody User entity){
        return service.updataPassword(entity);
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public @ResponseBody UserInfo validate(@RequestParam String username,@RequestParam String password){
        return service.validate(username,password);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST)
    public @ResponseBody UserInfo findByName(@RequestParam String username){
        return service.findByName(username);
    }


}
