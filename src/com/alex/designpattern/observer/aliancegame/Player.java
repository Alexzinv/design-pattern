package com.alex.designpattern.observer.aliancegame;

import cn.hutool.json.JSONObject;

import java.util.Random;

public class Player implements AbstractPlayer {

	private String name;
	private final Coordinate coordinate;
	private AllyControlCenter acc;

	public Player(String name){
		this.name = name;
		this.coordinate = new Coordinate(new Random().nextInt(100), new Random().nextInt(100));
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setAcc(AllyControlCenter acc) {
		this.acc = acc;
		acc.join(this);
	}

	@Override
	public void help(AbstractPlayer player, JSONObject param) {
		System.out.println("hold on " + player.getName() + " come to save you, 请求参数 => " + param.toString());
	}

	@Override
	public void beAttacked(JSONObject param) {
		System.out.println(this.name + "被攻击");
		System.out.println("坐标" + this.coordinate.toString());
		// acc.notifyObserver(name);
		acc.receiveAttackMessage(this, param);
	}

	@Override
	public AllyControlCenter getAcc() {
		return acc;
	}
}
