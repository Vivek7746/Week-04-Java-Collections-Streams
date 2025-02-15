package list_interface.remove_duplicates;

import java.util.*;

public class RemoveDuplicates {

    // Method to remove duplicates while preserving order
    public static void removeDuplicates(ArrayList<Integer> list) {
        // Using a LinkedHashSet to maintain order and remove duplicates
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);

        // Clearing and updating the original list
        list.clear();
        list.addAll(set);
    }

    public static void main(String[] args) {
        // Initializing the list
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));

        // Removing duplicates
        removeDuplicates(numbers);

        // Printing the updated list
        System.out.println("List after removing duplicates: " + numbers);
    }
}