package com.alex.designpattern.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 配置文件读取工具类
 */
public class ConfigUtil {

    /**
     * 读取配置文件
     * @param fileName 文件名
     * @param key      配置项
     * @return         配置项的值
     */
    public static String getProperty(String fileName, String key) {
        InputStream is = null;
        String value = "";
        try {
            is = new FileInputStream("resources/" + fileName);
            //is = ConfigUtil.class.getResourceAsStream("/"+fileName);
            Properties properties = new Properties();
            properties.load(is);
            value = properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return value;
            }
        }
    }

    /**
     * 读取xml配置文件
     * @param fileName 文件名
     * @param key      配置项
     * @return         配置项的值
     */
    public static String getXmlConfig(String fileName, String key){
        InputStream is = null;
        String value = "";
        try {
            //is = new FileInputStream("resources/" + fileName);
            is = ConfigUtil.class.getResourceAsStream("/"+fileName);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            Element root = doc.getRootElement();
            Element target = root.element(key);
            value = target.getText();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return value;
            }
        }
    }

    /**
     * 从properties文件读取并创建对象
     * @param fileName 配置文件名
     * @param key 类名配置项
     * @return 该类对应的对象实例
     */
    public static Object getBeanFromProp(String fileName, String key) {
        Object o = null;
        try {
            String className = getProperty(fileName, key);
            Class<?> clazz = Class.forName(className);
            o = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            return o;
        }
    }

    /**
     * 从xml文件读取并创建对象
     * @param fileName 配置文件名
     * @param key 类名配置项
     * @return 该类对应的对象实例
     */
    public static Object getBeanFromXml(String fileName, String key) {
        Object o = null;
        try {
            String className = getXmlConfig(fileName, key);
            Class<?> clazz = Class.forName(className);
            o = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            return o;
        }
    }
}
