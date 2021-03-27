package com.alex.designpattern.factory.simplefactory;

public class ChartFactory {

    public ChartFactory() {
    }
    
    public static Chart getChart(String charType){
        switch (charType) {
            case "histogram":
                return new Histogramchart();
            case "pin":
                return new Pinchart();
            case "line":
                return new Linechart();
            default:
                return null;
        }
    }
}
