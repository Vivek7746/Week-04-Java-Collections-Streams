package piped_streams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos));
            writer.write("Hello from Writer Thread!");
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in WriterThread: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error in ReaderThread: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writerThread = new WriterThread(pos);
            ReaderThread readerThread = new ReaderThread(pis);

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error in main: " + e.getMessage());
            e.printStackTrace();
        }
    }
}