package com.alex.designpattern.observer.aliancegame;

import cn.hutool.json.JSONObject;

import java.util.ArrayList;

// public abstract class AllyControlCenter {
public class AllyControlCenter {

	protected String allyName;
	protected ArrayList<AbstractPlayer> players;

	public AllyControlCenter(String allyName){
		this.allyName = allyName;
		players = new ArrayList<>();
		System.out.println(allyName + "战队组建成功");
	}

	public String getAllyName() {
		return allyName;
	}

	public void setAllyName(String allyName) {
		this.allyName = allyName;
	}

	public void join(AbstractPlayer abstractPlayer){
		// for (AbstractPlayer player : players) {
		// 	if(player.getName().equals(abstractPlayer.getName())){
		// 		System.out.println("玩家已有战队");
		// 		return;
		// 	}
		// }
		if(!players.contains(abstractPlayer)){
			players.add(abstractPlayer);
			System.out.println(abstractPlayer.getName() + "加入" + this.allyName + "战队");
		}else{
			System.out.println("玩家已有战队");
		}

	}

	public void quit(AbstractPlayer abstractPlayer){
		players.remove(abstractPlayer);
		System.out.println(abstractPlayer.getName() + "退出" + this.allyName + "战队");
	}

	//public abstract void notifyObserver(String name);

	@Deprecated
	void notifyObserver(String name) {
		System.out.println(this.allyName + "战队紧急通知，盟友" + name + "遭到敌人攻击!");
		for (AbstractPlayer obs : players) {
			if(!obs.getName().equalsIgnoreCase(name)){
				// obs.help();
			}
		}
	}

	private void notifyPlayers(AbstractPlayer player, JSONObject param){
		for (AbstractPlayer abstractPlayer : players) {
			if(player != abstractPlayer){
				abstractPlayer.help(abstractPlayer, param);
			}
		}
	}

	public void receiveAttackMessage(AbstractPlayer player, JSONObject param){
		System.out.println(allyName + "接收到来自: " + player.getName() + " 的救援请求，立刻发送通知 ... 请求参数 => " + param.toString());
		notifyPlayers(player, param);
	}
}
