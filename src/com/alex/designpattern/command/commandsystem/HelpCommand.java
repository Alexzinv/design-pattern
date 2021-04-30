package com.alex.designpattern.command.commandsystem;

public class HelpCommand implements ButtonCommand {

	private DisplayHelpClass disObj;

	public HelpCommand(){
		this.disObj = new DisplayHelpClass();
	}

	@Override
	public void execute(Object invoker, Object arg){
		System.out.println("invoker=" + invoker + ", arg=" + arg);
		FunctionButton button = (FunctionButton)invoker;
		System.out.println("按钮" + button.getText() + "被点击");
		disObj.display();
	}
}
