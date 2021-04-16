package com.alex.designpattern.facade.encrypt;

import java.io.File;

public class EncryptFacade extends AbstractEncryptFacade {

	private final CipherMachine cipher;

	public EncryptFacade(){
		cipher = new CipherMachine();
	}

	@Override
	public void fileEncrypt(File sourceFile, File destFile){
		System.out.println("开始读取文件...");
		String file = reader.readFile(sourceFile);
		System.out.println("读取成功，内容：");
		System.out.println(file);
		System.out.println("-------------------------------------------------");
		String base64 = cipher.encryptBase64(file);
		System.out.println("加密后的内容：");
		System.out.println(base64);
		writer.writeFile(base64, destFile);
		System.out.println("文件写入成功 -> " + destFile.getAbsolutePath());
	}
}
