package com.alex.designpattern.adapter.encryption;

public class Encryptor {
	public String encrypt(String plainText, String alg){
		return "confidential content: " + plainText + "Alg: " + alg;
	}
}
