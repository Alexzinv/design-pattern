package com.alex.designpattern.adapter.caradapter;

public class Client {
	public static void main(String[] args) {
		CarController controller = new PoliceCarAdapter(new PoliceSound(), new PoliceLamp());
		controller.move();
		controller.phonate();
		controller.twinkle();
	}
}
