package com.alex.designpattern.practice.test;

public class Guss {
	public static void main(String[] args) {
		int[] data = {1,0,1,0,1,0,1,0,1,0,1,0,1,1,0};
		int result = compute(data);
		System.out.println(result);
	}

	public static int compute(int[] gussArray){
		// 正确用1表示, 错误用0表示
		int total = 777;

		for (int i : gussArray) {
			if (i == 1) {
				total *= 2;
			} else {
				total -= 555;
			}
		}
		return total;
	}
}


