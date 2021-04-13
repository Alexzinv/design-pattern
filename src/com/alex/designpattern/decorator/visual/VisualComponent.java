package com.alex.designpattern.decorator.visual;

/**
 * 抽象类的构件
 */
public abstract class VisualComponent {

	protected String name;

	public abstract void display();

	public void hide(){
		System.out.println("隐藏控件" + name);
	}

	public void destroy(){
		System.out.println("销毁控件" + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
