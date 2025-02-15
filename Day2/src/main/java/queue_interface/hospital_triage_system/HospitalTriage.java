package queue_interface.hospital_triage_system;

import java.util.*;

class Patient {
    String name;
    int severity; // Higher value means higher severity

    // Constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

// Custom comparator to sort patients by severity (higher severity first)
class PatientComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.severity, p1.severity);
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        // PriorityQueue with custom comparator for sorting by severity
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new PatientComparator());

        // Adding patients to the queue
        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));

        // Treating patients based on severity
        System.out.println("Patients treated in order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll().name);
        }
    }
}