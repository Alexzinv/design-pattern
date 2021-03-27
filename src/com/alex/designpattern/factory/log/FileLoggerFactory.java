package com.alex.designpattern.factory.log;

public class FileLoggerFactory implements LoggerFactory{

    @Override
    public Logger createLogger() {
        return new FileLogger();
    }

    @Override
    public Logger createLogger(String param) {
        System.out.println("创建file logger:" + param);
        return new FileLogger();
    }

}
