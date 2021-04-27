package com.alex.designpattern.observer.aliancegame;

import cn.hutool.json.JSONObject;

public class Client {
	public static void main(String[] args) {
		// AllyControlCenter attackerX = new ConcreteAllyControlCenter("attackerX");

		AllyControlCenter wula = new AllyControlCenter("wula");


		Player player1, player2, player3, player4;

		player1 = new Player("AL");
		player2 = new Player("AH");
		player3 = new Player("CL");
		player4 = new Player("DL");

		JSONObject param = new JSONObject().set("位置", "(100, 200)").set("敌军人数", 1000).set("火力", "AK47");

		player1.setAcc(wula);
		player2.setAcc(wula);
		player3.setAcc(wula);
		player4.setAcc(wula);

		player1.beAttacked(param);
	}
}
