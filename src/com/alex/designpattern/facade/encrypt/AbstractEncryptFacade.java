package com.alex.designpattern.facade.encrypt;

import java.io.File;

/**
 * 抽象加密外观类
 */
public abstract class AbstractEncryptFacade {

	protected MyFileReader reader;
	protected MyFileWriter writer;

	public AbstractEncryptFacade(){
		reader = new MyFileReader();
		writer = new MyFileWriter();
	}

	public abstract void fileEncrypt(File sourceFile, File destFile);
}
