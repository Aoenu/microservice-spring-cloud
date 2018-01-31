package com.hand.security.model;

/**
 * Scopes
 * 
 * @author Levin
 *
 * 2017-05-25
 */
public enum Scopes {
    REFRESH_TOKEN;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
