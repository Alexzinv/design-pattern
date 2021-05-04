package com.alex.designpattern.builder.videoplayer;

public class Client {

	public static void main(String[] args) {
		VideoPlayerController controller = new VideoPlayerController();

		VideoPlayer player = controller.createPlayer(new Lite());
		System.out.println("精简模式 " + player);

		System.out.println("------------------------------------");

		VideoPlayer player1 = controller.createPlayer(new Normal());
		System.out.println("详细模式 " + player1);
	}
}
