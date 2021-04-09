package com.alex.designpattern.composite.killvirus;

public abstract class AbstractFile {
	protected String filePath;

	public abstract void add(AbstractFile file);

	public abstract void remove(AbstractFile file);

	public abstract AbstractFile getChild(int i);

	public abstract String killVirus();

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
