package com.alex.designpattern.factory.fileconvertor;

import org.junit.Test;

public class Client {

	@Test
	public void test1(){
		ExcelFileFactory excelFileFactory = new ExcelFileFactory();
		DataFile dataFile = excelFileFactory.createDataFile();
		dataFile.convert2Xml("D:/Document/1.xls");
	}
}
