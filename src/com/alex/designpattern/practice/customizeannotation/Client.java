package com.alex.designpattern.practice.customizeannotation;

import com.alex.designpattern.practice.customizeannotation.bean.Student;
import com.alex.designpattern.practice.customizeannotation.bean.StudentService;
import com.alex.designpattern.practice.customizeannotation.core.BeanLoader;

public class Client {
	public static void main(String[] args) {
		BeanLoader instance = BeanLoader.getInstance();
		Student s1 = instance.getBean(Student.class);
		Student s2 = instance.getBean(Student.class);
		System.out.println(s1 + " | " + s2);

		StudentService sv1 = instance.getBean(StudentService.class);
		StudentService sv2 = instance.getBean(StudentService.class);
		StudentService sv3 = instance.getBean("student_service");

		Student s3 = sv1.findStudentByNo("001");
		System.out.println(s3);
		System.out.println("单例");
		System.out.println(sv1 + " | " + sv2 + " | " + sv3);
	}
}
