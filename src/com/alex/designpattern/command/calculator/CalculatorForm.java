package com.alex.designpattern.command.calculator;

/**
 * 计算器
 */
public class CalculatorForm {
	private CalculateCommand command;

	public CalculateCommand getCommand() {
		return command;
	}

	public void setCommand(CalculateCommand command) {
		this.command = command;
	}

	public int compute(int a, int b){
		return command.calculate(a, b);
	}

	public Integer undo(){
		return command.undo();
	}

	public Integer getCurrentResult(){
		return command.getCurrentResult();
	}
}
