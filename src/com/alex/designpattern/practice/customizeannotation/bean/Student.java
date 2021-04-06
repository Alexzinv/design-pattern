package com.alex.designpattern.practice.customizeannotation.bean;

import com.alex.designpattern.practice.customizeannotation.annotation.Component;
import com.alex.designpattern.practice.customizeannotation.annotation.Prototype;

@Component(value = "student")
@Prototype
public class Student {
	private String name;
	private String no;
	private String phone;

	public Student(){
	}

	public Student(String name, String no, String phone) {
		this.name = name;
		this.no = no;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
