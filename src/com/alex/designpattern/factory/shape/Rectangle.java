package com.alex.designpattern.factory.shape;

public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw rectangle...");
    }

    @Override
    public void erase() {
        System.out.println("erase rectangle");
        
    }
    
}
