package com.alex.designpattern.builder.videoplayer;

public class VideoPlayerController {

	public VideoPlayer createPlayer(VideoPlayerBuilder builder){

		if(builder.isMenu()){
			builder.buildMenu();
		}
		if (builder.isList()) {
			builder.buildList();
		}
		builder.buildManWin();
		builder.buildController();
		return builder.build();
	}
}
