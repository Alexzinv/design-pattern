package com.alex.designpattern.builder.game;

import com.alex.designpattern.util.ConfigUtil;
import org.junit.Test;

public class Client {

	@Test
	public void actorTest(){
		ActorController controller = new ActorController();
		Actor actor = controller.construct(new AngleBuilder());
		System.out.println(actor);
	}

	@Test
	public void actorXmlTest(){
		try {
			ActorController controller = new ActorController();

			// String classname = ConfigUtil.getXmlConfig("actor.xml", "classname");
			// ActorBuilder actorBuilder = (ActorBuilder)Class.forName(classname).getDeclaredConstructor().newInstance();

			ActorBuilder actorBuilder = (ActorBuilder)ConfigUtil.getBeanFromXml("actor.xml", "classname");
			assert actorBuilder != null;

			Actor actor = controller.construct(actorBuilder);
			System.out.println(actor);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
