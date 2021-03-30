package com.alex.designpattern.adapter.caradapter;

public abstract class CarController {
	public void move(){
		System.out.println("move....");
	};

	public abstract void phonate();

	public abstract void twinkle();

	public void action(){
		move();
		phonate();
		twinkle();
	}
}
