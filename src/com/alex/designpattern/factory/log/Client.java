package com.alex.designpattern.factory.log;

import com.alex.designpattern.util.ConfigUtil;
import org.junit.Test;

public class Client {
    public static void main(String[] args) {
        try {
            String factoryClassName = ConfigUtil.getXmlConfig("logger.xml", "logger-class");
            Class<?> factoryClass = Class.forName(factoryClassName);
            LoggerFactory factory = (LoggerFactory)factoryClass.getDeclaredConstructor().newInstance();

            String param = ConfigUtil.getXmlConfig("logger.xml", "logger-param");

            Logger logger = factory.createLogger(param);

            int loggerLevel = Integer.parseInt(ConfigUtil.getXmlConfig("logger.xml", "logger-level"));
            logger.setCurrentLevel(loggerLevel);

            logger.info("fasf");
            logger.error("file");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void test(){
        DatabaseLoggerFactory databaseLoggerFactory = new DatabaseLoggerFactory();
        Logger createFactory = databaseLoggerFactory.createLogger();
        createFactory.error("database");
    }
}
