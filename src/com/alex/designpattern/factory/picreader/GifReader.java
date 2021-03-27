package com.alex.designpattern.factory.picreader;

public class GifReader implements ImageReader{
    @Override
    public Pic read(String path) {
        return new GifPic(path);
    }
}
