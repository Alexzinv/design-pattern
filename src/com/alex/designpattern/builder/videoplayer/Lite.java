package com.alex.designpattern.builder.videoplayer;

public class Lite extends VideoPlayerBuilder {

	@Override
	public boolean isMenu() {
		return false;
	}

	@Override
	public void buildMenu() {
	}

	@Override
	public boolean isList() {
		return false;
	}

	@Override
	public void buildList() {
	}

	@Override
	public void buildManWin() {
		videoPlayer.setManWin("主窗口");
	}

	@Override
	public void buildController() {
		videoPlayer.setController("控制条");
	}
}
