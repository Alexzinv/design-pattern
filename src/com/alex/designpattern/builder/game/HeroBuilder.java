package com.alex.designpattern.builder.game;

public class HeroBuilder extends ActorBuilder{
	@Override
	public void buildType() {
		actor.setType("hero");
	}

	@Override
	public void buildSex() {
		actor.setSex("male");
	}

	@Override
	public void buildFace() {
		actor.setFace("long");
	}

	@Override
	public void buildCostume() {
		actor.setCostume("silk");
	}

	@Override
	public void buildHairstyle() {
		actor.setHairstyle("black");
	}
}
