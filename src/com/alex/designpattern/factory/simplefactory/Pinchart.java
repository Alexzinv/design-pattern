package com.alex.designpattern.factory.simplefactory;

public class Pinchart implements Chart{

    public Pinchart(){
        System.out.println("Pinchart");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图");
    }
    
}
