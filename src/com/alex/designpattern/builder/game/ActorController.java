package com.alex.designpattern.builder.game;

public class ActorController {

	public Actor construct(ActorBuilder ab){
		ab.buildType();
		ab.buildSex();
		ab.buildFace();
		ab.buildCostume();
		if(!ab.isBareheaded()){
			ab.buildHairstyle();
		}
		return ab.createActor();
	}
}
