package com.alex.designpattern.factory.picreader;

public class Client {
    public static void main(String[] args) {
        GifReader gifReader = new GifReader();
        gifReader.read("/");

        JpgReader jpgReader = new JpgReader();
        jpgReader.read("/pic/");
    }
}
