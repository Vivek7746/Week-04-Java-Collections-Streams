package buffered_streams;

import java.io.*;

public class FileCopyComparison {
    private static final int BUFFER_SIZE = 4096; // 4 KB buffer

    public static void main(String[] args) {
        String sourceFile = "source.txt"; // Change to actual source file path
        String destBuffered = "destination_buffered.txt";
        String destUnbuffered = "destination_unbuffered.txt";

        // Measure and compare execution times
        long timeBuffered = copyWithBufferedStreams(sourceFile, destBuffered);
        long timeUnbuffered = copyWithUnbufferedStreams(sourceFile, destUnbuffered);

        System.out.println("Buffered Streams Time: " + timeBuffered + " nanoseconds");
        System.out.println("Unbuffered Streams Time: " + timeUnbuffered + " nanoseconds");
    }

    private static long copyWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}