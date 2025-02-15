package voting_system;

import java.util.*;

// Class representing a Voting System
class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); // Store votes by candidate
    private Map<String, Integer> orderedVoteMap = new LinkedHashMap<>(); // Maintain order of votes
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>(); // Store votes in sorted order

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVoteMap.put(candidate, orderedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display voting results in sorted order
    public void displaySortedResults() {
        System.out.println("Voting Results (Sorted by Candidate Name): " + sortedVoteMap);
    }

    // Display voting results in the order votes were cast
    public void displayOrderedResults() {
        System.out.println("Voting Results (Order of Voting): " + orderedVoteMap);
    }

    // Display final vote counts
    public void displayFinalResults() {
        System.out.println("Final Vote Counts: " + voteMap);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Casting sample votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        // Display results
        system.displayFinalResults();
        system.displaySortedResults();
        system.displayOrderedResults();
    }
}