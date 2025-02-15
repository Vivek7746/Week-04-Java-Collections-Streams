package queue_interface.stack_using_queues;

import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        queue1.offer(x);
    }

    // Pop operation (removes the top element)
    public int pop() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move elements to queue2, leaving the last one
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        // Last element is the top of the stack
        int top = queue1.poll();

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Top operation (returns the top element without removing it)
    public int top() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move elements to queue2, leaving the last one
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        // Last element is the top of the stack
        int top = queue1.poll();
        queue2.offer(top); // Reinsert the top element

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Should be 3
        System.out.println("Popped element: " + stack.pop()); // Should remove 3
        System.out.println("Top element after pop: " + stack.top()); // Should be 2
    }
}