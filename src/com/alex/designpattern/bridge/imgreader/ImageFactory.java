package com.alex.designpattern.bridge.imgreader;

public class ImageFactory {

	public static ImageImp getImp(String os){
		switch (os.toLowerCase()){
			case "windows":
				return new WindowsImp();
			case "linux":
				return new LinuxImp();
			case "unix":
				return new UnixImp();
			default:
				return new WindowsImp();
		}
	}

	public static Image getImage(String img){
		switch (img.toLowerCase()){
			case "jpg":
				return new JPGImage();
			case "png":
				return new PNGImage();
			case "bmp":
				return new BMPImage();
			default:
				return new JPGImage();
		}
	}
}
