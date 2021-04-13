package com.alex.designpattern.observer.aliancegame;

public class Client {
	public static void main(String[] args) {
		AllyControlCenter attackerX = new ConcreteAllyControlCenter("attackerX");

		Player player1, player2, player3, player4;

		player1 = new Player("AL");
		player2 = new Player("BX");
		player3 = new Player("KW");
		player4 = new Player("XG");

		attackerX.join(player1);
		attackerX.join(player2);
		attackerX.join(player3);
		attackerX.join(player4);

		player1.beAttacked(attackerX);
	}
}
