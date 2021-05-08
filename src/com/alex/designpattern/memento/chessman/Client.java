package com.alex.designpattern.memento.chessman;

/**
 * @author Alex
 */
public class Client {
	public static void main(String[] args) {
		MementoCaretaker caretaker = new MementoCaretaker();
		Chessman chess = new Chessman("车", 1, 1, ChessmanColor.RED);
		ChessmanMemento memento = chess.play(1, 3);
		caretaker.setMemento(memento);

		chess.play(5, 3);
		chess.restore(memento);
		System.out.println(chess.coord2Record(chess.getX(), chess.getY()));
	}
}
