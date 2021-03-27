package com.alex.designpattern.factory.os;

public class Client {
    public static void main(String[] args) {
        Button button = new Linux().createButton();
        button.info();

        new Windows().createText().info();
        new Unix().createButton().info();
    }
}
