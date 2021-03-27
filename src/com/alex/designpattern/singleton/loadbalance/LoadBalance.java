package com.alex.designpattern.singleton.loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalance {
	private static LoadBalance instance = null;
	private List<Server> serverList = new ArrayList<>();

	private LoadBalance(){
	}

	public static LoadBalance getInstance(){
		if (instance == null){
			synchronized (LoadBalance.class){
				if (instance == null){
					instance = new LoadBalance();
				}
			}
		}
		return instance;
	}

	public List<Server> getServerList(){
		return serverList;
	}

	public void addServer(Server server){
		serverList.add(server);
	}

	public Server getServer(String serverName){
		for (Server server : serverList) {
			if(server.getName().equals(serverName)){
				return server;
			}
		}
		return null;
	}

	public void removeServer(Server server){
		serverList.remove(server);
	}

	public void removeServer(String serverName){
		Server server = getServer(serverName);
		if(server != null) serverList.remove(server);
	}

	public Server dispatch(){
		Random random = new Random();
		Server server = serverList.get(random.nextInt(serverList.size()));
		return server;
	}

	@Override
	public String toString() {
		return "serverList=" + serverList;
	}
}
