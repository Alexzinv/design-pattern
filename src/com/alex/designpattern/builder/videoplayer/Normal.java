package com.alex.designpattern.builder.videoplayer;

public class Normal extends VideoPlayerBuilder {
	@Override
	public void buildMenu() {
		videoPlayer.setMenu("菜单");
	}

	@Override
	public void buildList() {
		videoPlayer.setPlayList("播放列表");
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
