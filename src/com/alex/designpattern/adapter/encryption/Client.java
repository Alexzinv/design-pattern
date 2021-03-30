package com.alex.designpattern.adapter.encryption;

public class Client {
	public static void main(String[] args) {
		EncryptController controller = new DatabaseAdapter();
		controller.save("afagjgh");
	}
}
