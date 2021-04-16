package com.alex.designpattern.facade.encrypt;

import java.io.File;

public class NewEncryptFacade extends AbstractEncryptFacade {

	private final NewCipherMachine cipher;

	public NewEncryptFacade(){
		cipher = new NewCipherMachine();
	}

	@Override
	public void fileEncrypt(File sourceFile, File destFile){
		System.out.println("开始读取文件...");
		String file = reader.readFile(sourceFile);
		System.out.println("读取成功，内容：");
		System.out.println(file);
		System.out.println("-------------------------------------------------");
		String md5 = cipher.encryptMd5(file);
		System.out.println("加密后的内容：");
		System.out.println(md5);
		writer.writeFile(md5, destFile);
		System.out.println("文件写入成功 -> " + destFile.getAbsolutePath());
	}
}
