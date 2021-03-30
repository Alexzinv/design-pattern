package com.alex.designpattern.adapter.caradapter;

import org.junit.Test;

public class Client {
	public static void main(String[] args) {
		CarController controller = new PoliceCarAdapter();
		controller.action();

	}

	@Test
	public void ambulanceTest(){
		CarController controller = new AmbulanceCarAdapter();
		controller.action();
	}
}
