package com.alex.designpattern.factory.shape;

public class ShapeFactory {

    public ShapeFactory(){}

    public static Shape getShape(String shapeType) throws UnsupportedShapeException{
//        switch (shapeType.toLowerCase()) {
//            case "circle":
//                return new Circle();
//            case "rectangle":
//                return new Rectangle();
//            case "triangle":
//                return new Triangle();
//            default:
//                throw new UnsupportedShapeException();
//        }
        return switch (shapeType.toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            case "triangle" -> new Triangle();
            default -> throw new UnsupportedShapeException();
        };

    }
}
