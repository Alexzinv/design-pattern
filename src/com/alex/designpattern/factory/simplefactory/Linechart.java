package com.alex.designpattern.factory.simplefactory;

public class Linechart implements Chart{

    public Linechart(){
        System.out.println("Linechart");
    }

    @Override
    public void display() {
        System.out.println("显示线图");
    }
    
}
