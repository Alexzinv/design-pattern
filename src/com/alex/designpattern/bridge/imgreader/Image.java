package com.alex.designpattern.bridge.imgreader;

/**
 * 抽象图像类
 */
public abstract class Image {
	protected ImageImp img;
	public void setImg(ImageImp img){
		this.img = img;
	}

	public abstract void showImage(String fileName);
}
