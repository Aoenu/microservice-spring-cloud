package com.hand.controller;

import com.hand.pojo.UserRole;
import com.hand.security.api.vo.user.UserInfo;
import com.hand.security.auth.token.extractor.TokenExtractor;
import com.hand.security.auth.token.verifier.TokenVerifier;
import com.hand.security.config.TokenProperties;
import com.hand.security.config.WebSecurityConfig;
import com.hand.security.exceptions.InvalidToken;
import com.hand.security.model.UserContext;
import com.hand.security.model.token.RawAccessToken;
import com.hand.security.model.token.RefreshToken;
import com.hand.security.model.token.Token;
import com.hand.security.model.token.TokenFactory;
import com.hand.service.UserInfoService;
import com.hand.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Levin
 * @date 2017-08-15.
 */
@RestController
public class GatewayController {

    @Autowired
    private TokenProperties tokenProperties;
    @Autowired
    private TokenVerifier tokenVerifier;
    @Autowired
    private TokenFactory tokenFactory;
    @Autowired
    private TokenExtractor tokenExtractor;

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserRoleService userRoleService;


    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }

    @GetMapping("/api/test2")
    public String test2() {
        return "test2";
    }

    @GetMapping("/manage/test3")
    public String test3() {
        return "test3";
    }

    @GetMapping("/refresh_token")
    public Token refreshToken(HttpServletRequest request) {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.TOKEN_HEADER_PARAM));
        RawAccessToken rawToken = new RawAccessToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, tokenProperties.getSigningKey()).orElseThrow(() -> new InvalidToken("Token验证失败"));


        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidToken("Token验证失败");
        }

        String subject = refreshToken.getSubject();
        UserInfo user = Optional.ofNullable(userInfoService.findByName(subject)).orElseThrow(() -> new UsernameNotFoundException("用户未找到: " + subject));
        List<UserRole> roles = Optional.ofNullable(userRoleService.getRoleByUser(user)).orElseThrow(() -> new InsufficientAuthenticationException("用户没有分配角色"));
        List<GrantedAuthority> authorities = roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.authority()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUserName(), authorities);
        return tokenFactory.createAccessToken(userContext);
    }


}
