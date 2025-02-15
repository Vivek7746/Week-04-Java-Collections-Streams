package list_interface.reverse_a_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseList {

    // Method to reverse an ArrayList
    public static ArrayList<Integer> ReverseArrayList(ArrayList<Integer> arraylist) {

        // Creating two variables left and right
        int left = 0, right = arraylist.size()-1;

        // Iterating and reversing by swapping
        for(; left <= right; left++, right--) {
            int temp = arraylist.get(left);
            arraylist.set(left, arraylist.get(right));
            arraylist.set(right, temp);
        }

        return arraylist;
    }

    // Method of reverse a LinkedList
    public static LinkedList<Integer> ReverseLinkedList(LinkedList<Integer> linkedList) {

        // Creating two variables left and right
        int left = 0, right = linkedList.size()-1;

        // Iterating and reversing by swapping
        for(; left <= right; left++, right--) {
            int temp = linkedList.get(left);
            linkedList.set(left, linkedList.get(right));
            linkedList.set(right, temp);
        }

        return linkedList;
    }

    public static void main(String[] args) {

        // Initialising ArrayList and LinkedList
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        LinkedList<Integer> linkedlist = new LinkedList<>();

        // Inserting elements
        for(int i = 1; i <= 5; i++) {
            arraylist.add(i);
            linkedlist.add(i);
        }

        // Calling method to reverse ArrayList
        ArrayList<Integer> reversedArraylist = ReverseArrayList(arraylist);

        // Calling method to reverse LinkedList
        LinkedList<Integer> reversedLinkedList = ReverseLinkedList(linkedlist);

        // Displaying the result
        System.out.println("Reversed Array List is " + reversedArraylist);
        System.out.println("Reversed Linked List is " + reversedLinkedList);
    }
}
