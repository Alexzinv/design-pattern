package com.alex.designpattern.memento.chessman;

/**
 * @author Alex
 */
public class Chessman {

	private String label;
	private int x;
	private int y;
	private ChessmanColor color;

	Chessman(String label, int x, int y, ChessmanColor color){
		this.label = label;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	/**
	 * 保存当前状态
	 */
	public ChessmanMemento save(){
		return new ChessmanMemento(label, x, y, color);
	}

	/**
	 * 恢复状态
	 * @param memento 上一步状态
	 */
	public void restore(ChessmanMemento memento){
		this.label = memento.getLabel();
		this.x = memento.getX();
		this.y = memento.getY();
		this.color = memento.getColor();
	}

	public String coord2Record(int newX, int newY){
		return this.color.toString() + ":" + label + ":" + newX + "," + newY;
	}

	/**
	 * 一步一保存
	 * @param newX 新的x坐标
	 * @param newY 新的y坐标
	 * @return 这一步的状态
	 */
	public ChessmanMemento play(int newX, int newY){
		String chessRecord = coord2Record(newX, newY);
		System.out.println(chessRecord);
		this.x = newX;
		this.y = newY;
		return save();
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
