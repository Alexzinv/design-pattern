package com.alex.designpattern.facade.encrypt;

import cn.hutool.core.io.file.FileWriter;

import java.io.File;

/**
 * 文件保存子系统
 */
public class MyFileWriter {

	/**
	 * 将文本保存到目标文件
	 * @param text 文本文件
	 * @param destFile 目标文件
	 */
	public void writeFile(String text, File destFile){
		FileWriter writer = new FileWriter(destFile);
		writer.write(text);
	}
}
