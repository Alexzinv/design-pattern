package com.alex.designpattern.factory.skin;

public class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TexField createTexField() {
        return new SpringTxtField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
