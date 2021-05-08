package com.alex.designpattern.memento.chessman;

/**
 * @author Alex
 */
public class ChessmanMemento {
	private String label;
	private int x;
	private int y;
	private ChessmanColor color;

	ChessmanMemento(String label, int x, int y, ChessmanColor color){
		this.label = label;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ChessmanColor getColor() {
		return color;
	}

	public void setColor(ChessmanColor color) {
		this.color = color;
	}
}
