package set_interface.union_and_intersection;

import java.util.*;

public class UnionIntersectionSets {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Compute Union
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Compute Intersection
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}