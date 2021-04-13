package com.alex.designpattern.practice.connectionpool;

import com.alex.designpattern.practice.connectionpool.pool.Customer;
import com.alex.designpattern.practice.connectionpool.pool.MyConnectionPool;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) {
		MyConnectionPool pool = MyConnectionPool.getInstance();
		// Connection con = pool.getConnection();

		ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);
		CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

		// 创建多线程获取连接池连接
		for(int i=0; i<THREAD_COUNT; i++){
			es.execute(()->{
				Connection con = pool.getConnection();
				List<Customer> customerList = queryCustomer(con, "");
				pool.freeConnection(con);
				latch.countDown();
			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//
		// List<Customer> customers = queryCustomer(con, "2");
		// for (Customer customer : customers) {
		//		System.out.println(customer);
		//	}

		// pool.freeConnection(con);

		pool.destroyPool();
	}

	private static final int THREAD_COUNT = 30;

	public static List<Customer> queryCustomer(Connection con, String keyword) {
		try {
			String sql = "select * from customers where name like '%" + keyword + "%'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Customer> custList = new ArrayList<>();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				Customer customer = new Customer();
				customer.setId(id).setName(name).setEmail(email).setBirth(birth);
				custList.add(customer);
			}
			rs.close();
			// 模拟一个耗时数据库操作
			TimeUnit.SECONDS.sleep((long) (new Random().nextInt(3)));
			return custList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
