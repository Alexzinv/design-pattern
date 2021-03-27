package com.alex.designpattern.factory.test;

import java.io.InputStream;
import java.util.Properties;

public class readConfigPros {
    public static void main(String[] args) {
        try {
            InputStream is = readConfigPros.class.getResourceAsStream("/config.properties");
            Properties properties = new Properties();
            properties.load(is);
            System.out.println("name=" + properties.getProperty("name"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
