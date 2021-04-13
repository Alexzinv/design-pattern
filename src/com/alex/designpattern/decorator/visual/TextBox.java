package com.alex.designpattern.decorator.visual;

public class TextBox extends VisualComponent {
	@Override
	public void display() {
		System.out.println("显示TextBox -> " + name);
	}

	/**
	 * 输入文本内容
	 * @param text 文本
	 */
	public void resize(String text){
		System.out.println("文本框" + name + "输入内容: text -> " + text);
	}
}
