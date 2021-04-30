package com.alex.designpattern.command.commandsystem;

/**
 * 功能键，充当调用者
 */
public class FunctionButton {

	private String text;

	public void click(ButtonCommand command, Object arg){
		command.execute(this, arg);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
