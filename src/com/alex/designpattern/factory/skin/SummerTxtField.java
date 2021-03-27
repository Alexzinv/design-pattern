package com.alex.designpattern.factory.skin;

public class SummerTxtField implements TexField{
    @Override
    public void inputText(String text) {
        System.out.println("夏天主题文本框，输入内容：" + text);
    }

    @Override
    public void display() {
        System.out.println("显示夏天主题文本框");
    }
}
