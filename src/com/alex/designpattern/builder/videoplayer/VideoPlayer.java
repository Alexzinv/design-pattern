package com.alex.designpattern.builder.videoplayer;

public class VideoPlayer {

	private String menu;
	private String playList;
	private String manWin;
	private String controller;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getPlayList() {
		return playList;
	}

	public void setPlayList(String playList) {
		this.playList = playList;
	}

	public String getManWin() {
		return manWin;
	}

	public void setManWin(String manWin) {
		this.manWin = manWin;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	@Override
	public String toString() {
		return "{" +
				"menu='" + menu + '\'' +
				", playList='" + playList + '\'' +
				", manWin='" + manWin + '\'' +
				", controller='" + controller + '\'' +
				'}';
	}
}
