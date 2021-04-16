package com.alex.designpattern.facade.encrypt;

import cn.hutool.core.codec.Base64;

/**
 * 加密子系统
 */
public class CipherMachine {

	/**
	 * 采用base64算法对文本加密
	 * @param plainText 纯文本
	 * @return base64编码串
	 */
	public String encryptBase64(String plainText){
		return Base64.encode(plainText);
	}
}
