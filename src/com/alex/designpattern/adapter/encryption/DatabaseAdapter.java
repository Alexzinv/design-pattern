package com.alex.designpattern.adapter.encryption;

import com.alex.designpattern.util.ConfigUtil;

public class DatabaseAdapter extends EncryptController{

	private Encryptor encryptor;

	public DatabaseAdapter(){
		this.encryptor = new Encryptor();
	}

	@Override
	public String encode(String text) {
		String alg = ConfigUtil.getProperty("encrypt.properties", "alg");
		return encryptor.encrypt(text, alg);
	}
}
