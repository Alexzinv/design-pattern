package com.alex.designpattern.practice.connectionpool.pool;

import java.sql.Date;

public class Customer {
	private int id;
	private String name;
	private String email;
	private Date birth;

	public int getId() {
		return id;
	}

	public Customer setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Customer setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}

	public Date getBirth() {
		return birth;
	}

	public Customer setBirth(Date birth) {
		this.birth = birth;
		return this;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", birth=" + birth +
				'}';
	}
}
