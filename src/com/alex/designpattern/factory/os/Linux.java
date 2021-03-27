package com.alex.designpattern.factory.os;

public class Linux implements Os{
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Text createText() {
        return new LinuxText();
    }
}
