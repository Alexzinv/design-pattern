package com.alex.designpattern.factory.shape;

public class Client {
    public static void main(String[] args) throws UnsupportedShapeException {
        Shape shape = ShapeFactory.getShape("circle");
        shape.draw();
        shape.erase();
    }
}
