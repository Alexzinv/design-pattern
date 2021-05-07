package com.alex.designpattern.practice.test;

public class BirthParty {
	public static void main(String[] args) {
		int sc2 = getSC2(236);
		System.out.println(sc2);
	}

	private static int getSC(int num){
		for (int age = 1; age < 100; age++){
			int sum = 0;
			for(int n = 0; n < 100; n++){
				sum += age + n;
				if (sum == num){
					System.out.println(n+1);
					return age;
				}
			}
		}
		return 0;
	}

	private static int getSC2(int num){
		for (int n = 1; n < 100; n++){
			int temp = num - n * (n + 1) / 2;
			if(temp%(n+1) == 0){
				System.out.println(n+1);
				return temp / (n+1);
			}
		}
		return 0;
	}

}
