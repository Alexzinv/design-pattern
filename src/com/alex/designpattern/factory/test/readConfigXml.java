package com.alex.designpattern.factory.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class readConfigXml {
    public static void main(String[] args) {
        try {
            InputStream is = readConfigXml.class.getResourceAsStream("/config.xml");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            Element name = doc.getRootElement().element("name");
            System.out.println("value: " + name.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
