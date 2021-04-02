package com.alex.designpattern.factory.fileconvertor;

import org.dom4j.Document;

public class TxtFile implements DataFile {

	static {
		System.out.println("初始化文本文件解析环境");
	}

	@Override
	public Document convert2Xml(String fileName) {
		System.out.println("将文本文件" + fileName + "转化为xml");
		return null;
	}
}
