package com.alex.designpattern.factory.os;

public class UnixButton implements Button {
    @Override
    public void info() {
        System.out.println("Unix button");
    }
}
