package file_handling;

import java.io.*;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FileHandling {

    public static void main(String[] args) {

        try(FileInputStream input = new FileInputStream("1input.txt")) {

            // Getting content of 1input.txt file
            int ch;
            String s = "";

            while((ch = input.read())!= -1) {
                s += (char)ch;
            }

            // creating FileOutputStream object
            FileOutputStream output = new FileOutputStream("1output.txt");

            // Writing in 1output.txt file
            output.write(s.getBytes());
            output.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
