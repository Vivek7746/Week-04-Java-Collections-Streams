package list_interface.rotate_list;

import java.util.*;

public class RotateList {

    // Method to rotate the list by given positions
    public static void rotateList(ArrayList<Integer> list, int positions) {
        int size = list.size();

        // Handling cases where positions exceed size
        positions = positions % size;

        // Creating a new list to store rotated elements
        ArrayList<Integer> rotated = new ArrayList<>();

        // Adding elements from the rotation index to the end
        for (int i = positions; i < size; i++) {
            rotated.add(list.get(i));
        }

        // Adding elements from the start to the rotation index
        for (int i = 0; i < positions; i++) {
            rotated.add(list.get(i));
        }

        // Updating the original list
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        // Initializing the list
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        // Defining the rotation value
        int rotateBy = 2;

        // Rotating the list
        rotateList(numbers, rotateBy);

        // Printing the rotated list
        System.out.println("Rotated List: " + numbers);
    }
}
