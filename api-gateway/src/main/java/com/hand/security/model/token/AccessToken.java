package com.hand.security.model.token;

import io.jsonwebtoken.Claims;

/**
 * 验证Token
 * 
 * @author vladimir.stankovic
 *
 *         May 31, 2016
 */
public final class AccessToken implements Token {
    private final String rawToken;
    private Claims claims;

    protected AccessToken(final String token, Claims claims) {
        this.rawToken = token;
        this.claims = claims;
    }

    public String getToken() {
        return this.rawToken;
    }

    public Claims getClaims() {
        return claims;
    }
}
