package list_interface.find_frequency;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class FindFrequency {

    // Method to store frequencies in a Map
    public static HashMap<String, Integer> getFrequency(ArrayList<String> data) {

        // Initialising a Map to store count
        HashMap<String, Integer> count = new HashMap<>();

        // Iterating over the ArrayList to store frequencies
        for(String string : data) {
            count.put(string, count.getOrDefault(string, 0) + 1);
        }

        // Returning the Frequency containing Map
        return count;
    }

    public static void main(String[] args) {

        // Initialising a List of String
        ArrayList<String> data = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange"));

        // Creating a Map to store frequency by calling a Method
        HashMap<String, Integer> frequency = getFrequency(data);

        // Printing the answer
        System.out.println("Frequencies : " + frequency);
    }
}
