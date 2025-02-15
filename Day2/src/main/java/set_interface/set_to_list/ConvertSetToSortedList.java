package set_interface.set_to_list;

import java.util.*;

public class ConvertSetToSortedList {
    public static List<Integer> convertToSortedList(HashSet<Integer> set) {
        ArrayList<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        System.out.println("Sorted List: " + convertToSortedList(set));
    }
}