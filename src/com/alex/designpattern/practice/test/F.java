package com.alex.designpattern.practice.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class F {
	public static void main(String[] args) {
		List<Integer> list = findNumerator();
	}

	public static List<Integer> findNumerator(){
		List<Integer> numList = new ArrayList<>();
		HashSet<Character> numSet = new HashSet<>();
		for (int num = 1234; num <= 9876; num++){
			numSet.clear();
			char[] chars = String.valueOf(num).toCharArray();
			boolean isCorrect = true;
			for (char c : chars) {
				if('0' == c || !numSet.add(c)){
					isCorrect = false;
					break;
				}
			}
			if (!isCorrect){
				continue;
			}

			int denominator = num * 3;
			chars = String.valueOf(denominator).toCharArray();
			if(5 != chars.length){
				continue;
			}
			for (char c : chars) {
				if('0' == c || !numSet.add(c)){
					isCorrect = false;
					break;
				}
			}
			if (!isCorrect){
				continue;
			}
			numList.add(num);
		}
		return numList;
	}
}
