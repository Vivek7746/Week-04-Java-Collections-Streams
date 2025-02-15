package queue_interface.binary_number;

import java.util.*;

public class BinaryNumbersQueue {

    // Method to generate the first N binary numbers
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Enqueue first binary number
        queue.offer("1");

        // Generate N binary numbers
        for (int i = 0; i < N; i++) {
            String binary = queue.poll();
            result.add(binary);

            // Generate next two binary numbers and enqueue
            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " binary numbers: " + generateBinaryNumbers(N));
    }
}