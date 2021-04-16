package com.alex.designpattern.facade.encrypt;

import java.io.File;

public class Client {

	public static void main(String[] args) {
		// AbstractEncryptFacade facade = new EncryptFacade();
		// facade.fileEncrypt(new File("file/1.txt"), new File("file/1_base64.txt"));

		AbstractEncryptFacade facade1 = new NewEncryptFacade();
		facade1.fileEncrypt(new File("file/1.txt"), new File("file/1_md5.txt"));
	}
}
