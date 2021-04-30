package com.alex.designpattern.command.commandsystem;

/**
 * 具体命令
 */
public class ExitCommand implements ButtonCommand {

	private final SystemExitClass exitobj;

	public ExitCommand(){
		this.exitobj = new SystemExitClass();
	}

	@Override
	public void execute(Object invoker, Object arg){
		System.out.println("invoker=" + invoker + ", arg=" + arg);
		FunctionButton button = (FunctionButton)invoker;
		System.out.println("按钮" + button.getText() + "被点击");
		exitobj.exit();
	}
}
