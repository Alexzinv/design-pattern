package com.alex.designpattern.command.commandsystem;

/**
 * 接收者
 */
public class SystemExitClass {

	public void exit(){
		System.out.println("退出系统 ...");
		System.exit(0);
	}
}
