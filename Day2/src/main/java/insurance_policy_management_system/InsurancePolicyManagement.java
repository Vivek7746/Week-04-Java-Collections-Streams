package insurance_policy_management_system;

import java.util.*;
import java.time.*;

// Class representing an Insurance Policy
class InsurancePolicy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    // Constructor
    public InsurancePolicy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    // toString method for displaying policy details
    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolder + ", Expiry: " + expiryDate;
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>(); // Store policies by policy number
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>(); // Maintain insertion order
    private NavigableMap<LocalDate, InsurancePolicy> sortedPolicyMap = new TreeMap<>(); // Sort by expiry date

    // Add a policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }

    // Retrieve a policy by its number
    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring in the next 30 days
    public List<InsurancePolicy> getExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        return new ArrayList<>(sortedPolicyMap.subMap(today, true, threshold, true).values());
    }

    // List all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedPolicyMap.headMap(today, true).clear(); // Remove expired from sorted map
        policyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        orderedPolicyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
    }

    // Display all policies
    public void displayPolicies() {
        for (InsurancePolicy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Adding sample policies
        system.addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.now().plusDays(10)));
        system.addPolicy(new InsurancePolicy("P002", "Jane Smith", LocalDate.now().plusDays(40)));
        system.addPolicy(new InsurancePolicy("P003", "Alice Johnson", LocalDate.now().minusDays(5))); // Expired

        // Display policies
        System.out.println("All Policies:");
        system.displayPolicies();

        // Retrieve policy by number
        System.out.println("\nRetrieving Policy P001: " + system.getPolicy("P001"));

        // List expiring policies
        System.out.println("\nPolicies expiring within 30 days:");
        System.out.println(system.getExpiringPolicies());

        // List policies by holder
        System.out.println("\nPolicies for John Doe:");
        System.out.println(system.getPoliciesByHolder("John Doe"));

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        system.displayPolicies();
    }
}