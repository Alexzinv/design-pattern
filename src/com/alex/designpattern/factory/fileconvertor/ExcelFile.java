package com.alex.designpattern.factory.fileconvertor;

import org.dom4j.Document;
import org.dom4j.tree.DefaultDocument;

public class ExcelFile implements DataFile {

	static {
		System.out.println("初始化Excel文件解析环境");
	}

	@Override
	public Document file2Xml(String fileName) {
		System.out.println("将Excel文件" + fileName + "转化为xml");
		return new DefaultDocument(fileName);
	}
}
