package com.alex.designpattern.flyweight.igochessman;

/**
 * 黑子享元类
 */
public class BlackIgoChessman extends IgoChessman {

	public BlackIgoChessman(){
		color = IgoChessman.BLACK;
	}

	@Override
	public void display(int index, Coordinate coordinate) {
		System.out.println("黑子 -> " + this);
		System.out.println("第" + index + "手, 位置 -> [" + coordinate.getX() + ", " + coordinate.getY() + "]");
		System.out.println();
	}
}
