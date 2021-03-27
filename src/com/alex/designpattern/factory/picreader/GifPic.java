package com.alex.designpattern.factory.picreader;

public class GifPic extends Pic{
    public GifPic(){
        System.out.println("gif picture");
    }

    public GifPic(String path){
        System.out.println("读取路径 " + path + " 下的gif图片");
    }
}
