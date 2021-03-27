package com.alex.designpattern.singleton.loadbalance;

public class Client {
	public static void main(String[] args) {
		LoadBalance b1 = LoadBalance.getInstance();
		LoadBalance b2 = LoadBalance.getInstance();
		LoadBalance b3 = LoadBalance.getInstance();

		System.out.println(b1.hashCode() + " | " + b2.hashCode() + " | " + b3.hashCode());

		Server s1 = new Server("s1", "10.1.1.2");
		Server s2 = new Server("s2", "10.1.1.3");
		Server s3 = new Server("s3", "10.1.1.4");
		b1.addServer(s1);
		b2.addServer(s2);
		b3.addServer(s3);

		System.out.println(b1);
		System.out.println(b1.dispatch());

		b1.removeServer(s2);
		System.out.println(b1);
	}
}
