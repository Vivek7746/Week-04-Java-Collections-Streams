package list_interface.find_nth_element;

import java.util.*;

public class FindNthFromEnd {

    // Method to find the Nth element from the end
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        // Using two-pointer approach
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        // Moving the first pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                return "Invalid N (larger than list size)";
            }
        }

        // Moving both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // The second pointer now points to the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        // Initializing the LinkedList
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));

        // Defining the position from the end
        int n = 2;

        // Finding and printing the Nth element from the end
        System.out.println("Nth element from end: " + findNthFromEnd(list, n));
    }
}