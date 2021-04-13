package com.alex.designpattern.decorator.visual;

public class BlackBorderDecorator extends ComponentDecorator {

	public void addBlackBorder(){
		System.out.println("为构件" + visualComponent.name + "添加黑色边框");
	}

	@Override
	public void display() {
		addBlackBorder();
		super.display();
	}
}
