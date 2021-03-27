package com.alex.designpattern.builder.game;

/**
 * 抽象建造者
 */
public abstract class ActorBuilder {
	protected Actor actor = new Actor();

	public abstract void buildType();

	public abstract void buildSex();

	public abstract void buildFace();

	public abstract void buildCostume();

	public abstract void buildHairstyle();

	// 勾子方法
	public boolean isBareheaded(){
		return false;
	}

	protected Actor createActor(){
		return actor;
	}
}
