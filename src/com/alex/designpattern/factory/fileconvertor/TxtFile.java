package com.alex.designpattern.factory.fileconvertor;

import org.dom4j.Document;
import org.dom4j.tree.DefaultDocument;

public class TxtFile implements DataFile {

	static {
		System.out.println("初始化文本文件解析环境");
	}

	@Override
	public Document file2Xml(String fileName) {
		System.out.println("将文本文件" + fileName + "转化为xml");
		return new DefaultDocument(fileName);
	}
}
