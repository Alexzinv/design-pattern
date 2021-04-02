package com.alex.designpattern.factory.fileconvertor;

public class TxtFileFactory implements DataFileFactory {
	@Override
	public DataFile createDataFile() {
		return new TxtFile();
	}
}
