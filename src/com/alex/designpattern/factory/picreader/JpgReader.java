package com.alex.designpattern.factory.picreader;

public class JpgReader implements ImageReader{
    @Override
    public Pic read(String path) {
        return new JpgPic(path);
    }
}
