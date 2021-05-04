package com.alex.designpattern.factory.fileconvertor;

import org.dom4j.Document;


public interface DataFile {
	/**
	 * 将文件转化为xml
	 * @param fileName 文件名
	 * @return xml的Document对象
	 */
	Document file2Xml(String fileName);
}
