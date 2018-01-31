package com.hand.security.exceptions;

/**
 * 无效的Token
 * 
 * @author Levin
 *
 * @time 2017-05-25
 */
public class InvalidToken extends RuntimeException {
	
    private static final long serialVersionUID = -294671188037098603L;

    public InvalidToken(String msg) {
        super(msg);
    }

    public InvalidToken(String msg, Throwable t) {
        super(msg, t);
    }
}
