package count_words;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "textfile.txt"; // Change to actual file path

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = wordCountMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());

        System.out.println("Total word count: " + wordCountMap.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println("Top 5 most frequent words:");
        sortedWords.stream().limit(5).forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}