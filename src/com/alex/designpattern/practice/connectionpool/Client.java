package com.alex.designpattern.practice.connectionpool;

import com.alex.designpattern.practice.connectionpool.pool.MyConnectionPool;

public class Client {
	public static void main(String[] args) {
		MyConnectionPool pool = MyConnectionPool.getInstance();
		System.out.println(pool);
	}
}
