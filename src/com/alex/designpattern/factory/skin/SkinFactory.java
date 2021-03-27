package com.alex.designpattern.factory.skin;

public interface SkinFactory {

    Button createButton();

    TexField createTexField();

    ComboBox createComboBox();
}
