package com.alex.designpattern.practice.connectionpool.pool;

import com.alex.designpattern.util.ConfigUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyConnectionPool {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private final String dbUrl;
	private final String dbUser;
	private final String dbPass;
	private final int initCount;
	private final int maxCount;
	private final Queue<Connection> freeConPool = new LinkedBlockingDeque<>();  // 空闲池
	private final Queue<Connection> inuseConPool = new LinkedBlockingDeque<>();  // 在用池


	private volatile static MyConnectionPool instance = null;

	private MyConnectionPool(){
		String fileName = "connection-pool.properties";
		dbUrl = ConfigUtil.getProperty(fileName, "db_url");
		dbUser = ConfigUtil.getProperty(fileName, "db_user");
		dbPass = ConfigUtil.getProperty(fileName, "db_password");
		initCount = Integer.parseInt(ConfigUtil.getProperty(fileName, "init_count"));
		maxCount = Integer.parseInt(ConfigUtil.getProperty(fileName, "max_count"));

		// 初始化连接池
		initPool(initCount);
	}

	public static MyConnectionPool getInstance(){
		if(instance == null){
			synchronized (MyConnectionPool.class){
				if(instance == null){
					instance = new MyConnectionPool();
				}
			}
		}
		return instance;
	}

	/**
	 * 创建initCount个连接
	 * @param initCount 连接数
	 */
	private void initPool(int initCount){
		for(int i=0; i<initCount; i++){
			Connection connection = createConnection();
			freeConPool.add(connection);
		}
		System.out.println("连接池初始化完成！初始连接数: " + initCount + "  最大连接数：" + maxCount);
	}

	private Connection createConnection(){
		try {
			Class.forName(Driver);
			return DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
