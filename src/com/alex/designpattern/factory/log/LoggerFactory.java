package com.alex.designpattern.factory.log;

public interface LoggerFactory {
    
    Logger createLogger();

    Logger createLogger(String param);
}
