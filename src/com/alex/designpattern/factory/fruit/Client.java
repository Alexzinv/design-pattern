package com.alex.designpattern.factory.fruit;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class Client {
    public static void main(String[] args) {
        try {
            InputStream is = Client.class.getResourceAsStream("/fruit.xml");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            Element name = doc.getRootElement().element("name");
            Fruit fruit = FruitProduce.getFruit(name.getText());
            if(fruit != null){
                fruit.info();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
