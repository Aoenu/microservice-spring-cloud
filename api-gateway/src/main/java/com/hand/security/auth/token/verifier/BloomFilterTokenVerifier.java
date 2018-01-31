package com.hand.security.auth.token.verifier;

import org.springframework.stereotype.Component;

/**
 * Token验证过滤器
 * 
 * @author Levin
 *
 * @time 2017-05-25
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
