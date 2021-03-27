package com.alex.designpattern.factory.skin;

import com.alex.designpattern.util.ConfigUtil;

public class Client {
    public static void main(String[] args) {
//        SummerSkinFactory summer = new SummerSkinFactory();
//        summer.createButton().display();
//        summer.createTexField().inputText("fafaga");
//
//        String option = summer.createComboBox().getOption(3);
//        System.out.println(option);

        SkinFactory skinFactory = (SkinFactory) ConfigUtil.getBeanFromProp("skin.properties", "factory-class");
        skinFactory.createTexField().inputText("fafa");
    }
}
