package com.alex.designpattern.observer.aliancegame;

import java.util.ArrayList;

public abstract class AllyControlCenter {

	protected String allyName;
	protected ArrayList<Observer> players = new ArrayList<>();

	public String getAllyName() {
		return allyName;
	}

	public void setAllyName(String allyName) {
		this.allyName = allyName;
	}

	public void join(Observer observer){
		players.add(observer);
		System.out.println(observer.getName() + "加入" + this.allyName + "战队");
	}

	public void quit(Observer observer){
		players.remove(observer);
		System.out.println(observer.getName() + "退出" + this.allyName + "战队");
	}

	public abstract void notifyObserver(String name);
}
