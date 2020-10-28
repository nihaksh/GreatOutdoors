package com.cg.go.exception;

public class WishlistNotFoundException extends RuntimeException{
    public WishlistNotFoundException(){

    }

    public WishlistNotFoundException(String msg){
        super(msg);
    }
}
