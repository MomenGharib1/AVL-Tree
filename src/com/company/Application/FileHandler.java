package com.company.Application;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class FileHandler {
    private static boolean isPathValid(String path) {
        try {

            Paths.get(path);

        } catch (InvalidPathException ex) {
            return false;
        }

        return true;
    }
    public static File loadFile(String path){
        if (isPathValid(path)){
            File file = new File(path);
            return file;
        }else
            return null;
    }
}
