package com.alex.designpattern.command.calculator;

public class SubstractCommand extends CalculateCommand {

	private final Substracter substracter;

	public SubstractCommand(){
		this.substracter = new Substracter();
	}

	@Override
	public int calculate(int a, int b) {
		int result = substracter.substract(a, b);
		resultStack.push(result);
		return result;
	}
}
