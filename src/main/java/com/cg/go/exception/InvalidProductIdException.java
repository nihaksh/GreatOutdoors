package com.cg.go.exception;

public class InvalidProductIdException extends RuntimeException{

    public InvalidProductIdException(){

    }

    public InvalidProductIdException(String msg){
        super(msg);
    }
}
