package com.alex.designpattern.factory.skin;

public class SpringTxtField implements TexField{
    @Override
    public void inputText(String text) {
        System.out.println("春天主题文本框，输入内容：" + text);
    }

    @Override
    public void display() {
        System.out.println("显示春天主题文本框");
    }
}
