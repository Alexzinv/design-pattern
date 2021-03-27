package com.alex.designpattern.factory.os;

public class LinuxButton implements Button {
    @Override
    public void info() {
        System.out.println("Linux button");
    }
}
