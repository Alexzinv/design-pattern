package com.alex.designpattern.composite.killvirus;

public class VideoFile extends AbstractFile {

	public VideoFile(){
	}

	public VideoFile(String filePath){
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
		System.out.print("视频文件杀毒，正在查杀" + filePath + "\t\t");
		// 模拟病毒状态
		double rand = Math.random();
		if(rand<0.6){
			return "文件无毒";
		}
		return "文件有病毒，查杀成功";
	}
}
