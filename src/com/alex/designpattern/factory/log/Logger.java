package com.alex.designpattern.factory.log;

public abstract class Logger {
    
    protected int currentLevel = LoggerLevel.INFO;
    /**
     * 输出日志
     * @param level 日志级别
     * @param logContent
     */
    abstract void writeLog(int level, String logContent);

    private void writeLogUnderCurrentLevel(int level, String logContent){
        if(level < currentLevel){
            return;
        }
        writeLog(level, logContent);
    }

    void info(String logContent){
        writeLog(LoggerLevel.INFO, logContent);
    }

    void warnning(String logContent){
        writeLog(LoggerLevel.WARNNING, logContent);
    }

    void error(String logContent){
        writeLog(LoggerLevel.ERROR, logContent);
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    
    
}
