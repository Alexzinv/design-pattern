package com.alex.designpattern.prototype.shallowcopy;

import java.util.ArrayList;
import java.util.List;

public class Student implements Cloneable{
	private String no;
	private String name;
	private int age;
	private List<String> classmate;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getClassmate() {
		return classmate;
	}

	public void setClassmate(List<String> classmate) {
		this.classmate = classmate;
	}

	@Override
	public String toString() {
		return "Student{" +
				"no='" + no + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", classmate=" + classmate +
				'}';
	}

	@Override
	protected Student clone() throws CloneNotSupportedException {
		Student student = new Student();
		student.setNo(no);
		student.setName(name);
		student.setAge(age);
		List<String> newClassMate = new ArrayList<>(classmate);
		student.setClassmate(newClassMate);

		return student;
	}
}
