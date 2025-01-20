package com.saki.designPattern.adapter.extend;

import java.io.IOException;

public class FileIOAdapterMain {
    public static void main(String[] args) {
        FileIO fileIO = new FileProperties("C:\\software\\project\\ProgramingPractice\\computer\\src\\main\\resources");
        try {
            fileIO.readFromFile("file.txt");
            System.out.println(fileIO.getValue("year"));
            fileIO.setValue("year", "2018");
            fileIO.setValue("month", "05");
            fileIO.setValue("day", "05");
            fileIO.writeToFile("newFile.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
