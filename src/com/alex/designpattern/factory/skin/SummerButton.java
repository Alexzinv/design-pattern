package com.alex.designpattern.factory.skin;

public class SummerButton implements Button{

    @Override
    public void click() {
        System.out.println("夏天主题按钮被点击");
    }

    @Override
    public void display() {
        System.out.println("显示夏天主题按钮");
    }
}
