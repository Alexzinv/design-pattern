package com.alex.designpattern.factory.shape;

public class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw triangle...");
        
    }

    @Override
    public void erase() {
        System.out.println("erase triangle");
    }
    
}
