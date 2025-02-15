package queue_interface.reverse_queue;

import java.util.*;

public class ReverseQueue {

    // Method to reverse a queue using only queue operations
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue all elements and push onto a stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Step 2: Pop all elements from the stack and enqueue back to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}