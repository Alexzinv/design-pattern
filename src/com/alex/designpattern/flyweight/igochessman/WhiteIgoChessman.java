package com.alex.designpattern.flyweight.igochessman;

/**
 * 白子享元类
 */
public class WhiteIgoChessman extends IgoChessman {

	public WhiteIgoChessman(){
		color = IgoChessman.WHITE;
	}

	@Override
	public void display(int index, Coordinate coordinate) {
		System.out.println("白子 -> " + this);
		System.out.println("第" + index + "手, 位置 -> [" + coordinate.getX() + ", " + coordinate.getY() + "]");
		System.out.println();
	}
}
