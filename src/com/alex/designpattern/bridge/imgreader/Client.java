package com.alex.designpattern.bridge.imgreader;

import com.alex.designpattern.util.ConfigUtil;
import org.junit.Test;

public class Client {

	@Test
	public void imgTest(){
		LinuxImp imp = new LinuxImp();
		BMPImage image = new BMPImage();
		image.setImg(imp);
		String fileName = "D:/image/1.bmp";
		image.showImage(fileName);
	}

	@Test
	public void imgTest2(){
		Image image = (Image)ConfigUtil.getBeanFromProp("ImageConfig.properties", "imageFormat");
		ImageImp os = (ImageImp)ConfigUtil.getBeanFromProp("ImageConfig.properties", "os");
		image.setImg(os);
		String fileName = "D:/image/1.bmp";
		image.showImage(fileName);
	}

	@Test
	public void imgTest3(){
		String os = ConfigUtil.getXmlConfig("imageConfig.xml", "os");
		// String type = ConfigUtil.getXmlConfig("imageConfig.xml", "type");
		ImageImp imp = ImageFactory.getImp(os);
		String fileName = "D:/image/1.bmp";
		String[] fileSplit = fileName.split("\\.");
		Image image = ImageFactory.getImage(fileSplit[fileSplit.length-1]);
		image.setImg(imp);
		image.showImage(fileName);
	}
}
