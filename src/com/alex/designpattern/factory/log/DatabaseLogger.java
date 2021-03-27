package com.alex.designpattern.factory.log;

public class DatabaseLogger extends Logger{

    @Override
    public void writeLog(int level, String logContent) {
        String content = "日志级别" + level + "文件日志类型：" + logContent;
        if(level == LoggerLevel.ERROR){
            System.err.println(content);
        }else{
            System.out.println(content);
        }
    }
    
}
