package com.alex.designpattern.composite.killvirus;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {
	public static void main(String[] args) {
		// Folder folder = new Folder("D:/Coding/C++");
		// folder.add(new TextFile("asm.txt"));
		// folder.add(new ImageFile("ak47.png"));
		// folder.add(new VideoFile("cykablate.mp4"));
		// folder.killVirus();
		Folder folder = generateFolder(new File("D://Coding"));
		folder.killVirus();
	}

	/**
	 * 将给定的文件夹转化为folder
	 * @param rootFolderFile 磁盘上的某文件夹
	 * @return 生成的folder
	 */
	public static Folder generateFolder(File rootFolderFile){
		String[] textType = {".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".txt", ".pdf", ".java"};
		String[] imgType = {".png", ".jpg"};
		String[] videoType = {".mp4", ".flv", ".avi"};

		Folder rootFolder = new Folder(rootFolderFile.getAbsolutePath());
		// 获取子文件夹和子文件
		File[] children = rootFolderFile.listFiles();
		assert children != null;
		for (File child : children) {
			if (child.isDirectory()){
				// 如果是文件夹，则递归生成
				Folder folder = generateFolder(child);
				rootFolder.add(folder);
			}else {
				// 文本文件，包括 doc,docx,xls,xlsx,ppt,pptx,txt,pdf
				String fileName = child.getName();

				for (String item : textType) {
					if (fileName.endsWith(item)) {
						TextFile file = new TextFile();
						file.setFilePath(fileName);
						rootFolder.add(file);
					}
				}
				for (String value : imgType) {
					if (fileName.endsWith(value)) {
						ImageFile imageFile = new ImageFile();
						imageFile.setFilePath(fileName);
						rootFolder.add(imageFile);
					}
				}
				for (String s : videoType) {
					if (fileName.endsWith(s)) {
						VideoFile videoFile = new VideoFile();
						videoFile.setFilePath(fileName);
						rootFolder.add(videoFile);
					}
				}
			}
		}
		return rootFolder;
	}
}
