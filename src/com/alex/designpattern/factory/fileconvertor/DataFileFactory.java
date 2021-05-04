package com.alex.designpattern.factory.fileconvertor;

public interface DataFileFactory {

	/**
	 * 创建文件
	 * @return DataFile
	 */
	DataFile createDataFile();
}
