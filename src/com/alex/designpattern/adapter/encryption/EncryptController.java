package com.alex.designpattern.adapter.encryption;

public abstract class EncryptController {
	public void save(String content){
		String enc = encode(content);
		System.out.println("save to database! encode content: "+ enc);
	}

	public abstract String encode(String text);

}
