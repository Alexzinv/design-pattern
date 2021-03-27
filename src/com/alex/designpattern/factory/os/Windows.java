package com.alex.designpattern.factory.os;

public class Windows implements Os{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Text createText() {
        return new WindowsText();
    }
}
