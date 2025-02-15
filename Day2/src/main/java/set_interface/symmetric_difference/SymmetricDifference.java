package set_interface.symmetric_difference;

import java.util.*;

public class SymmetricDifference {
    public static HashSet<Integer> findSymmetricDifference(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2); // Union
        HashSet<Integer> common = new HashSet<>(set1);
        common.retainAll(set2); // Intersection
        result.removeAll(common); // Remove common elements
        return result;
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + findSymmetricDifference(set1, set2));
    }
}