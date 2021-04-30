package com.alex.designpattern.command.commandsystem;

import cn.hutool.json.JSONObject;

public class Client {
	public static void main(String[] args) {
		FunctionButton button = new FunctionButton();
		ButtonCommand exitCommand = new ExitCommand();
		ButtonCommand helpCommand = new HelpCommand();

		JSONObject arg1 = new JSONObject().set("value", 1000).set("type", "fruit");
		JSONObject arg2 = new JSONObject().set("value", 2000).set("type", "milk");

		button.setText("帮助");
		button.click(helpCommand, arg1);

		// button.click(() -> System.out.println("Hello Command"));
		button.setText("查询");
		JSONObject arg3 = new JSONObject().set("name", "alex").set("age", 100);
		button.click((invoker, arg) -> System.out.println("invoker=" + invoker + "arg=" + arg), arg3);

		button.setText("取消");
		JSONObject arg4 = new JSONObject().set("name", "aaaa").set("age", 200);
		button.click(new ButtonCommand() {
			@Override
			public void execute(Object invoker, Object arg) {
				System.out.println("invoker=" + invoker + ", arg=" + arg);
				FunctionButton button = (FunctionButton)invoker;
				System.out.println("按钮" + button.getText() + "被点击");
			}
		}, arg4);

		button.setText("退出");
		button.click(exitCommand, arg2);
	}
}
