package com.alex.designpattern.factory.skin;

public class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TexField createTexField() {
        return new SummerTxtField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
