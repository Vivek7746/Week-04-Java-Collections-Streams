package image_to_bytearray;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg"; // Change to actual image path
        String outputImagePath = "output.jpg";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            // Write byte array back to image file
            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image conversion successful. Output saved as " + outputImagePath);
        } catch (IOException e) {
            System.out.println("Error during image processing: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        return Files.readAllBytes(Paths.get(imagePath));
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputPath);
             ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}