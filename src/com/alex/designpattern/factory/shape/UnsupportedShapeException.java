package com.alex.designpattern.factory.shape;

public class UnsupportedShapeException extends Exception{

    private static final long serialVersionUID = 5862366149453241028L;
    
    public UnsupportedShapeException(){

    }

    public UnsupportedShapeException(String msg){
        super(msg);
    }
}
