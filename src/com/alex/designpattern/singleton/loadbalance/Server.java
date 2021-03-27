package com.alex.designpattern.singleton.loadbalance;


public class Server {
	private String name;
	private String ip;

	public Server() {
	}

	public Server(String name, String ip) {
		this.name = name;
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Server{" +
				name + "@" + ip +
				"}";
	}
}
