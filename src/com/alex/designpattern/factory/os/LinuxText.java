package com.alex.designpattern.factory.os;

public class LinuxText implements Text{
    @Override
    public void info() {
        System.out.println("Linux text");
    }
}
