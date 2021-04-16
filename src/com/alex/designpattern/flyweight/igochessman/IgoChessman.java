package com.alex.designpattern.flyweight.igochessman;

/**
 * 抽象围棋类
 */
public abstract class IgoChessman {

	// 内部状态
	public static final String BLACK = "black";
	public static final String WHITE = "white";
	protected String color;

	public String getColor(){
		return color;
	}

	public abstract void display(int index, Coordinate coordinate);
}
