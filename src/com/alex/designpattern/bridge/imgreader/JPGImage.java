package com.alex.designpattern.bridge.imgreader;

import java.util.Random;

public class JPGImage extends Image {
	@Override
	public void showImage(String fileName) {
		System.out.println("显示jpg图片：" + fileName);
		Matrix m = new Matrix();
		// 生成随机数模拟解析图片
		Random random = new Random();
		for(int i=0; i<Matrix.width; i++){
			for(int j=0; j<Matrix.height; j++){
				int pixel = random.nextInt(10);
				m.getPixelArray()[i][j] = pixel;
			}
		}
		img.doPaint(m);
	}
}
