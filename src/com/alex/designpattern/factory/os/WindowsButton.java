package com.alex.designpattern.factory.os;

public class WindowsButton implements Button {
    @Override
    public void info() {
        System.out.println("window button");
    }
}
