package com.alex.designpattern.decorator.visual;

public class Client {
	public static void main(String[] args) {
		Window window = new Window();
		window.setName("idea");

		ComponentDecorator decorator1 = new ScrollBarDecorator();
		decorator1.setVisualComponent(window);
		decorator1.display();

		ComponentDecorator decorator2 = new BlackBorderDecorator();
		decorator2.setVisualComponent(decorator1);
		decorator2.display();

		window.resize(800, 600);
		window.hide();
		window.destroy();
	}
}
