package com.alex.designpattern.factory.picreader;

public class JpgPic extends Pic{
    public JpgPic(){
        System.out.println("jpg picture");
    }

    public JpgPic(String path){
        System.out.println("读取路径 " + path + " 下的jpg图片");
    }
}
