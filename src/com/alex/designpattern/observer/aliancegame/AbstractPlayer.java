package com.alex.designpattern.observer.aliancegame;

import cn.hutool.json.JSONObject;

public interface AbstractPlayer {

	String getName();

	void setName(String name);

	void help(AbstractPlayer player, JSONObject param);

	void beAttacked(JSONObject param);

	AllyControlCenter getAcc();

	void setAcc(AllyControlCenter acc);
}
