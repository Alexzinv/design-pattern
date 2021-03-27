package com.alex.designpattern.builder.computer;

public class ComputerClient {
	public static void main(String[] args) {
		ComputerController controller = new ComputerController();
		Computer computer = controller.construct(new Server());
		System.out.println(computer);
	}
}
