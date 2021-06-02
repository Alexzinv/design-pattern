package com.alex.designpattern.prototype.weekreport;

import java.io.Serializable;

/**
 * @author Alex
 */
public class Attachment implements Serializable {
	private String name;

	public Attachment(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void download(){
		System.out.println("下载附件");
	}

	@Override
	public String toString() {
		return "Attachment{" +
				"name='" + name + '\'' +
				'}';
	}
}
