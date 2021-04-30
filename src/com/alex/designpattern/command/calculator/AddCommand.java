package com.alex.designpattern.command.calculator;

public class AddCommand extends CalculateCommand {

	private final Adder adder;

	public AddCommand(){
		this.adder = new Adder();
	}

	@Override
	public int calculate(int a, int b) {
		int result = adder.add(a, b);
		resultStack.push(result);
		return result;
	}
}
