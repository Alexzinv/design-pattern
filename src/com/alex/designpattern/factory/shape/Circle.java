package com.alex.designpattern.factory.shape;

public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw circle...");
    }

    @Override
    public void erase() {
        System.out.println("erase circle");
    }
    
}
