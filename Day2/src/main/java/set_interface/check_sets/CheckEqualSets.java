package set_interface.check_sets;

import java.util.*;

public class CheckEqualSets {
    public static boolean areSetsEqual(HashSet<Integer> set1, HashSet<Integer> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("Are sets equal? " + areSetsEqual(set1, set2));
    }
}