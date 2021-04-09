package com.alex.designpattern.composite.killvirus;

import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFile {
	private final List<AbstractFile> fileList = new ArrayList<>();

	public Folder(){
	}

	public Folder(String filePath){
		this.filePath = filePath;
	}

	@Override
	public void add(AbstractFile file) {
		fileList.add(file);
	}

	@Override
	public void remove(AbstractFile file) {
		fileList.remove(file);
	}

	@Override
	public AbstractFile getChild(int i) {
		return fileList.get(i);
	}

	@Override
	public String killVirus() {
		System.out.println("查杀路径: " + filePath);
		for (AbstractFile file : fileList) {
			String s = file.killVirus();
			if (s != null){
				System.out.println(s);
			}
		}
		return null;
	}
}
