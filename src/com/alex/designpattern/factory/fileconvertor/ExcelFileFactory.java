package com.alex.designpattern.factory.fileconvertor;

public class ExcelFileFactory implements DataFileFactory {
	@Override
	public DataFile createDataFile() {
		return new ExcelFile();
	}
}
