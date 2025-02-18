package filter_streams;

import java.io.*;

public class UppercaseToLowercaseConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt"; // Change to actual file path
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("Conversion completed. Output saved in " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}