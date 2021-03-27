package com.alex.designpattern.builder.game;

public class DevilBuilder extends ActorBuilder{
	@Override
	public void buildType() {
		actor.setType("devil");
	}

	@Override
	public void buildSex() {
		actor.setSex("male");
	}

	@Override
	public void buildFace() {
		actor.setFace("argly");
	}

	@Override
	public void buildCostume() {
		actor.setCostume("fe");
	}

	@Override
	public void buildHairstyle() {
		// actor.setHairstyle("bod");
	}

	@Override
	public boolean isBareheaded() {
		return true;
	}
}
