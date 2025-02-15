package queue_interface.circular_buffer_simulation;

import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    // Constructor to initialize buffer
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Enqueue operation (overwrite oldest if full)
    public void enqueue(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity;

        // If buffer is full, move front pointer
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite oldest element
        }
    }

    // Get buffer as a list
    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(front + i) % capacity]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        System.out.println("Buffer: " + cb.getBuffer()); // [1, 2, 3]

        cb.enqueue(4); // Overwrites 1
        System.out.println("Buffer after adding 4: " + cb.getBuffer()); // [2, 3, 4]
    }
}