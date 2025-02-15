package list_interface.reverse_a_list;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static list_interface.reverse_a_list.ReverseList.ReverseArrayList;
import static list_interface.reverse_a_list.ReverseList.ReverseLinkedList;
import static org.junit.jupiter.api.Assertions.*;

class ReverseListTest {

    @Test
    void reverseArrayList() {

        ArrayList<Integer> originalArrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> desiredResult = new ArrayList<>(Arrays.asList(5,4,3,2,1));

        ArrayList<Integer> actualResult = ReverseArrayList(originalArrayList);

        Assertions.assertEquals(desiredResult, actualResult);
    }

    @Test
    void reverseLinkedList() {

        LinkedList<Integer> originalLinkedList = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        LinkedList<Integer> desiredResult = new LinkedList<>(Arrays.asList(5,4,3,2,1));

        LinkedList<Integer> actualResult = ReverseLinkedList(originalLinkedList);

        Assertions.assertEquals(desiredResult, actualResult);
    }
}