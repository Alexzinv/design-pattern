package com.alex.designpattern.command.calculator;

public class Client {
	public static void main(String[] args) {
		CalculatorForm form = new CalculatorForm();
		AddCommand addCommand = new AddCommand();
		form.setCommand(addCommand);

		int result = form.compute(100, 200);
		int result2 = form.compute(200, 300);
		int result3 = form.compute(400, 300);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);

		form.undo();
		Integer undoResult = form.undo();
		Integer currentResult = form.getCurrentResult();
		System.out.println("undoResult -> " + undoResult);
		System.out.println("currentResult -> " + currentResult);

		SubstractCommand substractCommand = new SubstractCommand();
		form.setCommand(substractCommand);

		System.out.println("---------------------------");

		int result4 = form.compute(200, 100);
		int result5 = form.compute(200, 50);
		System.out.println(result3);
		System.out.println(result4);
	}
}
