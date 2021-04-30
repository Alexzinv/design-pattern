package com.alex.designpattern.command.commandsystem;

/**
 * 抽象命令接口
 */
@FunctionalInterface
public interface ButtonCommand {

	void execute(Object invoker, Object arg);
}
