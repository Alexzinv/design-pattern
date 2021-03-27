package com.alex.designpattern.factory.test;

public class Nvwa {
    public Nvwa(){

    }

    public static Person getPerson(String s){
        switch (s.toUpperCase()){
            case "M":
                return new Man();
            case "W":
                return new Woman();
            case "R":
                return new Robot();
            default:
                return null;
        }
    }
}
