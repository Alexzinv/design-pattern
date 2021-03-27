package com.alex.designpattern.builder.game;

public class AngleBuilder extends ActorBuilder{
	@Override
	public void buildType() {
		actor.setType("angle");
	}

	@Override
	public void buildSex() {
		actor.setSex("female");
	}

	@Override
	public void buildFace() {
		actor.setFace("write");
	}

	@Override
	public void buildCostume() {
		actor.setCostume("silk");
	}

	@Override
	public void buildHairstyle() {
		actor.setHairstyle("write");
	}
}
