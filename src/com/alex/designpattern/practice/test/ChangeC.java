package com.alex.designpattern.practice.test;

public class ChangeC {
	private static int total = 0;
	private static int exN = 0;

	public static void main(String[] args) {
		int total = getTotal(100);
		System.out.println(total);
	}

	private static int getTotal(int init){
		total += init;
	    int ex = init / 3;
	    exN += init % 3;
	    if (exN % 3 == 0){
	    	exN = 0;
	    	total += 1;
	    }
	    if(ex == 0){
	    	return total;
	    }
	    return getTotal(ex);
	}
}
