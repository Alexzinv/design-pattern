package com.alex.designpattern.observer.session1;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	private static void addAllListeners(Session session){
		SessionListener listener = new SessionListenerImpl();
		session.addListener(listener);

		SessionListener listener1 = new SessionListenerImpl2();
		session.addListener(listener1);
	}

	public static void main(String[] args) {

		int threadCount = 5;
		CountDownLatch latch = new CountDownLatch(threadCount);
		ExecutorService es = Executors.newFixedThreadPool(threadCount);
		for(int i=0; i<threadCount; i++){
			final int index = i;
			es.execute(() -> {
				HttpSession session = new HttpSession();
				addAllListeners(session);
				String uuid = IdUtil.fastSimpleUUID();
				session.setSessionId(uuid);

				JSONObject user = new JSONObject().set("name", "user_" + index).set("age", 20);
				session.setAttribute("user", user);

				// 模拟用户停留后退出
				try {
					Thread.sleep((long)(Math.random()*5000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				session.removeAttribute("user");
				latch.countDown();
			});
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

}
