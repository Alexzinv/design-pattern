package com.alex.designpattern.factory.log;

public class DatabaseLoggerFactory implements LoggerFactory{

    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }

    @Override
    public Logger createLogger(String param) {
        System.out.println("创建database logger:" + param);
        return new DatabaseLogger();
    }

}
