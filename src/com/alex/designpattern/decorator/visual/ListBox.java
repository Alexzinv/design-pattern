package com.alex.designpattern.decorator.visual;

import java.util.ArrayList;
import java.util.List;

public class ListBox extends VisualComponent {

	private final List<String> list = new ArrayList<>();

	@Override
	public void display() {
		System.out.println("显示ListBox -> " + name);
	}

	public void addItem(String item){
		list.add(item);
	}

	public void removeItem(String item){
		list.remove(item);
	}

	public String getItem(int index){
		return list.get(index);
	}
}
