package com.alex.designpattern.bridge.imgreader;

/**
 * 像素矩阵
 */
public class Matrix {
	public static final int width = 80;
	public static final int height = 60;
	private int[][] pixelArray = new int[width][height];

	public int[][] getPixelArray() {
		return pixelArray;
	}
}
