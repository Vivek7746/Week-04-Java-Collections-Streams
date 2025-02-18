package checked_exception;

import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args) {

        // Checking if the file exists
        try(FileReader file = new FileReader("data.txt")) {

            // Printing content of data.txt file
            int ch;

            while((ch = file.read()) != -1) {
                System.out.print((char)ch);
            }
        }
        // Throwing exception if it doesn't exist
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}