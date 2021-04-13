package com.alex.designpattern.practice.connectionpool.pool;

import com.alex.designpattern.util.ConfigUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyConnectionPool {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final int STEP = 2;   // 新增连接的步长
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

	/**
	 * 创建一个新连接
	 * @return 连接对象
	 */
	private Connection createConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private void increasePool(){
		if(freeConPool.size() + inuseConPool.size() <= maxCount){
			for(int i=0; i<STEP; i++){
				Connection connection = createConnection();
				freeConPool.add(connection);
			}
		}
	}

	/**
	 * 从空闲池中获取可用连接
	 * @return 获取可用连接
	 */
	public synchronized Connection getConnection(){
		Connection con = freeConPool.poll();
		if(con == null){
			System.out.println("当前没有可用连接，马上申请新连接... inuse_pool_size=" + inuseConPool.size());
			while(inuseConPool.size() >= maxCount){
				System.err.println("已达到最大连接，无法创建新连接，等待中...");
				// 等待一个随机时间
				try {
					Thread.sleep((long)(Math.random()*1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//再次尝试连接
				return getConnection();
			}
			// 尚未达到最大连接数, 创建新连接放入空闲池, getConnection必须从池中获取
			// 增大连接池
			increasePool();
			// 再次尝试获取连接
			return getConnection();
		}
		// 拿到可用连接则放入在用池
		inuseConPool.add(con);
		System.out.println("获取连接成功! con=" + con);
		return con;
	}

	/**
	 * 释放连接到空闲池子
	 */
	public void freeConnection(Connection con){
		inuseConPool.remove(con);
		freeConPool.add(con);
		System.out.println("释放连接成功，当前可用连接数为" + freeConPool.size());
	}

	/**
	 * 销毁整个连接池
	 */
	public void destroyPool(){
		try {
			while (!inuseConPool.isEmpty()){
				Connection con = inuseConPool.poll();
				con.close();
			}
			while (!freeConPool.isEmpty()){
				Connection con = freeConPool.poll();
				con.close();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("连接池已销毁!");
	}
}
