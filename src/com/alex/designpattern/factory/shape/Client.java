package com.alex.designpattern.factory.shape;

import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) {
        Shape shape = null;
        try {
            // shape = ShapeFactory.getShape("circle");
            //shape = ShapeFactory.getShape3("circle");
            shape = ShapeFactory.getShape4(ShapeEnum.rectangle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        shape.draw();
        shape.erase();
    }
}
