package com.alex.designpattern.decorator.visual;

public class Window extends VisualComponent {
	@Override
	public void display() {
		System.out.println("显示Window -> " + name);
	}

	/**
	 * 调整窗口大小
	 * @param width 宽度
	 * @param height 高度
	 */
	public void resize(int width, int height){
		System.out.println("调整窗口" + name + "大小: width -> " + width + " height -> " + height);
	}
}
