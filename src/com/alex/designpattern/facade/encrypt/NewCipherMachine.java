package com.alex.designpattern.facade.encrypt;

import cn.hutool.crypto.SecureUtil;

/**
 * 新的加密子系统
 */
public class NewCipherMachine {

	/**
	 * 采用md5算法对明文加密
	 * @param plainText 明文
	 * @return 密文
	 */
	public String encryptMd5(String plainText){
		return SecureUtil.md5(plainText);
	}
}