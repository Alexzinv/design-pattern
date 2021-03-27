package com.alex.designpattern.factory.skin;

public class SpringButton implements Button{

    @Override
    public void click() {
        System.out.println("春天主题按钮被点击");
    }

    @Override
    public void display() {
        System.out.println("显示春天主题按钮");
    }
}
