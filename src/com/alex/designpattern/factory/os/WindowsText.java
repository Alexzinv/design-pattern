package com.alex.designpattern.factory.os;

public class WindowsText implements Text{
    @Override
    public void info() {
        System.out.println("Windows text");
    }
}
