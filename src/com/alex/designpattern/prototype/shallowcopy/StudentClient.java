package com.alex.designpattern.prototype.shallowcopy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {

	@Test
	public void test1() throws CloneNotSupportedException {
		List<String> classmates = new ArrayList<>();
		classmates.add("001");
		classmates.add("002");
		classmates.add("003");

		Student student = new Student();
		student.setNo("007");
		student.setName("ag");
		student.setAge(100);
		student.setClassmate(classmates);

		Student cloneStudent = student.clone();
		cloneStudent.setNo("008");
		cloneStudent.setName("fwe");
		cloneStudent.setAge(50);
		cloneStudent.getClassmate().add("004");

		System.out.println(student);
		System.out.println(cloneStudent);
		System.out.println(student.hashCode() + " | " + cloneStudent.hashCode());
		System.out.println(student.getClassmate().hashCode() + " | " + cloneStudent.getClassmate().hashCode());

	}
}
