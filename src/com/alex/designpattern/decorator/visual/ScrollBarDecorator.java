package com.alex.designpattern.decorator.visual;

public class ScrollBarDecorator extends ComponentDecorator {

	public void addScrollBar(){
		System.out.println("为构件" + visualComponent.name + "添加滚动条");
	}

	@Override
	public void display() {
		addScrollBar();
		super.display();
	}
}
