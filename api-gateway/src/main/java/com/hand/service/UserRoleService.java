package com.hand.service;

import com.google.common.collect.Lists;
import com.hand.pojo.UserInfo;
import com.hand.pojo.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Levin
 * @date 2017-08-15.
 */
@Service
public class UserRoleService {

    public List<UserRole> getRoleByUser(UserInfo user) {
//        if("test".equals(user.getUserName())) {
//            //@see ExpressionUrlAuthorizationConfigurer  private static String hasAnyRole(String... authorities) 带 ROLE_
//            return Lists.newArrayList(new UserRole("ROLE_ADMIN"));
//        }
//        if("member".equals(user.getUserName())) {
//            //@see ExpressionUrlAuthorizationConfigurer  private static String hasAnyRole(String... authorities) 带 ROLE_
//            return Lists.newArrayList(new UserRole("ROLE_MEMBER"));
//        }
//        return null;
        return Lists.newArrayList(new UserRole("ROLE_"+user.getUserRole()));
    }
}
