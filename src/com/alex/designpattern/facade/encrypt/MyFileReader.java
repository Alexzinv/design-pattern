package com.alex.designpattern.facade.encrypt;

import cn.hutool.core.io.file.FileReader;

import java.io.File;

/**
 * 文件读取子系统
 */
public class MyFileReader {

	/**
	 * 读取文本文件内容
	 * @param textFile 文本文件
	 * @return 文件内容
	 */
	public String readFile(File textFile){
		FileReader reader = new FileReader(textFile);
		return reader.readString();
	}
}
