package com.alex.designpattern.builder.videoplayer;

public abstract class VideoPlayerBuilder {

	protected VideoPlayer videoPlayer = new VideoPlayer();

	public boolean isMenu(){
		return true;
	}

	public boolean isList(){
		return true;
	}

	public abstract void buildMenu();

	public abstract void buildList();

	public abstract void buildManWin();

	public abstract void buildController();

	public VideoPlayer build(){
		return videoPlayer;
	}
}
