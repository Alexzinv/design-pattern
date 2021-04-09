package com.alex.designpattern.composite.killvirus;

public class TextFile extends AbstractFile {

	public TextFile(){
	}

	public TextFile(String filePath){
		this.filePath = filePath;
	}

	@Override
	public void add(AbstractFile file) {
		System.err.println("不支持的操作！");
	}

	@Override
	public void remove(AbstractFile file) {
		System.err.println("不支持的操作！");
	}

	@Override
	public AbstractFile getChild(int i) {
		System.err.println("不支持的操作！");
		return null;
	}

	@Override
	public String killVirus() {
		System.out.print("文本文件杀毒，正在查杀" + filePath + "\t\t");
		// 模拟病毒状态
		double rand = Math.random();
		if(rand<0.4){
			return "文件无毒";
		}
		return "文件有病毒，查杀成功";
	}
}
