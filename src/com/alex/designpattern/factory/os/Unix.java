package com.alex.designpattern.factory.os;

public class Unix implements Os{
    @Override
    public Button createButton() {
        return new UnixButton();
    }

    @Override
    public Text createText() {
        return new UnixText();
    }
}
