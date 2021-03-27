package com.alex.designpattern.singleton.test;

import com.alex.designpattern.singleton.lazy.SingleTonEnum;
import com.alex.designpattern.singleton.starv.SingleTon1;
import org.junit.Test;

public class SingleTonTest {


	@Test
	public void test1(){
		SingleTon1 instance = SingleTon1.getInstance();
		SingleTon1 instance2 = SingleTon1.getInstance();
		System.out.println(instance.hashCode() + " | " + instance2.hashCode());
	}

	@Test
	public void test2(){
		SingleTonEnum instance = SingleTonEnum.INSTANCE;
		SingleTonEnum instance2 = SingleTonEnum.INSTANCE;
		System.out.println(instance.hashCode() + " | " + instance2.hashCode());
	}
}
