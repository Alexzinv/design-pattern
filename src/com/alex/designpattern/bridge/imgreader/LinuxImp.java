package com.alex.designpattern.bridge.imgreader;

public class LinuxImp implements ImageImp {
	@Override
	public void doPaint(Matrix m) {
		System.out.println("在Linux下显示像素矩阵:");
		int[][] pixelArray = m.getPixelArray();
		for(int i=0; i<Matrix.width; i++){
			for(int j=0; j<Matrix.height; j++){
				System.out.print(pixelArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}
