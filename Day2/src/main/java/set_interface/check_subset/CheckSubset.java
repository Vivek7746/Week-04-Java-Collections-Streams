package set_interface.check_subset;

import java.util.*;

public class CheckSubset {
    public static boolean isSubset(HashSet<Integer> set1, HashSet<Integer> set2) {
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Is set1 a subset of set2? " + isSubset(set1, set2));
    }
}