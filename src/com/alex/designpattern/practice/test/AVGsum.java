package com.alex.designpattern.practice.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AVGsum {

	private static int total = 0;

	public static void main(String[] args) {
		int total = getTotal(1314, 10);
		System.out.println(total);
	}

	private static int getTotal(int num, int times){
		if(times == 0){
			return total;
		}
		int[] ints = num2arr(num);
		for (int i : ints) {
			total += i*i;
		}
		return getTotal(total, times-1);
	}

	private static int[] num2arr(int num){
		String s = String.valueOf(num);
		int[] arr = new int[s.length()];
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			arr[i] = (int)c - 48;
		}
		return arr;
	}
}
