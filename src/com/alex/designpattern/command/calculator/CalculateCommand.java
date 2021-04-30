package com.alex.designpattern.command.calculator;

import java.util.Stack;

/**
 * 抽象计算命令
 */
public abstract class CalculateCommand {

	protected Stack<Integer> resultStack = new Stack<>();

	public abstract int calculate(int a, int b);

	/**
	 * 撤销并返回
	 * @return 撤销的结果
	 */
	public Integer undo(){
		if(resultStack.isEmpty()){
			return null;
		}
		return resultStack.pop();
	}

	/**
	 * 获取最近的计算结果
	 * @return 栈顶元素
	 */
	public Integer getCurrentResult(){
		if(resultStack.isEmpty()){
			return null;
		}
		return resultStack.lastElement();
	}

}
