package com.alex.designpattern.practice.customizeannotation.bean;

import com.alex.designpattern.practice.customizeannotation.annotation.Component;
import com.alex.designpattern.practice.customizeannotation.annotation.SingleTon;

@Component(value = "student_service")
@SingleTon
public class StudentService {
	/**
	 * 模拟查询学生信息
	 * @param no
	 * @return
	 */
	public Student findStudentByNo(String no){
		Student stu = new Student();
		stu.setName("aaa");
		stu.setNo(no);
		stu.setPhone("1908038");

		return stu;
	}
}
