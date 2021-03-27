package com.alex.designpattern.factory.simplefactory;

public class Histogramchart implements Chart{

    public Histogramchart(){
        System.out.println("Histogramchart");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图");
    }
    
}
