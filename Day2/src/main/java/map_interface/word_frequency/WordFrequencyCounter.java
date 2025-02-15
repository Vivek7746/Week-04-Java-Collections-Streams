package map_interface.word_frequency;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    // Method to count word frequencies in a text file
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Normalize text: remove punctuation and convert to lowercase
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Split text into words
        String[] words = text.split("\\s+");

        // Count word frequencies
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println("Word Frequencies: " + countWordFrequency(input));
    }
}