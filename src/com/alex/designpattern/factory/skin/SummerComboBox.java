package com.alex.designpattern.factory.skin;

public class SummerComboBox extends ComboBox {

    @Override
    public String getOption(int index) {
        return options.get(index);
    }

    @Override
    public void display() {
        System.out.println("显示夏天主题下拉列表");
    }
}
