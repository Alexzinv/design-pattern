package com.alex.designpattern.factory.skin;

public class SpringComboBox extends ComboBox {

    @Override
    public String getOption(int index) {
        return options.get(index);
    }

    @Override
    public void display() {
        System.out.println("显示春天主题下拉列表");
    }
}
