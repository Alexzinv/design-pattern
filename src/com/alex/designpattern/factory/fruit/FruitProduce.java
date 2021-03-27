package com.alex.designpattern.factory.fruit;

public class FruitProduce {
    public static Fruit getFruit(String s){
        switch (s.toLowerCase()){
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "orange":
                return new Orange();
            default:
                return null;
        }
    }
}
