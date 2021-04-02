package com.alex.designpattern.factory.shape;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    public ShapeFactory(){}

    private static final Map<String, Shape> ShapeMap = new HashMap<>();
    static {
        ShapeMap.put("circle", new Circle());
        ShapeMap.put("rectangle", new Rectangle());
        ShapeMap.put("triangle", new Triangle());
    }

    /**
     * 使用枚举创建
     * @param shapeName
     * @return shape
     */
    public static Shape getShape4(ShapeEnum shapeName) throws UnsupportedShapeException {
        return switch (String.valueOf(shapeName)) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            case "triangle" -> new Triangle();
            default -> throw new UnsupportedShapeException();
        };
        // if (ShapeEnum.circle == shapeName){
        //     return new Circle();
        // }else if(ShapeEnum.rectangle == shapeName){
        //     return new Rectangle();
        // }else if(ShapeEnum.triangle == shapeName){
        //     return new Triangle();
        // }else {
        //     throw new UnsupportedShapeException();
        // }
    }

    /**
     * 使用map取值
     * @param shapeType
     * @return shape
     */
    public static Shape getShape3(String shapeType) throws UnsupportedShapeException {
        String s = shapeType.toLowerCase();
        if(!ShapeMap.containsKey(s)){
            throw new UnsupportedShapeException("无法创建形状" + shapeType);
        }
        return ShapeMap.get(s);
    }

    /**
     * 使用反射创建
     * @param shapeType
     * @return shape
     */
    public static Shape getShape2(String shapeType) throws UnsupportedShapeException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String packageName = "com.alex.designpattern.factory.";
        // 首字母转大写
        String substring = shapeType.substring(1);
        String initialS = String.valueOf(shapeType.toCharArray()[0]).toUpperCase();
        String className = packageName + initialS + substring;

        return (Shape) Class.forName(className).getDeclaredConstructor().newInstance();
    }

    public static Shape getShape(String shapeType) throws UnsupportedShapeException {
        return switch (shapeType.toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            case "triangle" -> new Triangle();
            default -> throw new UnsupportedShapeException();
        };
    }

}
