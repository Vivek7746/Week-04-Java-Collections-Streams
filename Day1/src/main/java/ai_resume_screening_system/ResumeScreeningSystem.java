package ai_resume_screening_system;

import java.util.*;

// Abstract class representing a Job Role
abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Candidate: " + candidateName + ", Experience: " + experienceYears + " years";
    }
}

// Specific job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private List<T> resumeList = new ArrayList<>();

    public void addResume(T resume) {
        resumeList.add(resume);
    }

    public void removeResume(T resume) {
        resumeList.remove(resume);
    }

    public List<T> getResumes() {
        return resumeList;
    }

    // Wildcard method to display any type of resume
    public static void displayResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println(resume);
        }
    }
}

// Main class to test the AI-Driven Resume Screening System
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        Resume<DataScientist> dataScientistResumes = new Resume<>();
        Resume<ProductManager> productManagerResumes = new Resume<>();

        // Adding resumes
        softwareEngineerResumes.addResume(new SoftwareEngineer("Ram", 5));
        softwareEngineerResumes.addResume(new SoftwareEngineer("Shyam", 3));

        dataScientistResumes.addResume(new DataScientist("Anjali", 4));
        dataScientistResumes.addResume(new DataScientist("Ravi", 6));

        productManagerResumes.addResume(new ProductManager("Priya", 7));
        productManagerResumes.addResume(new ProductManager("Amit", 8));

        // Displaying resumes
        System.out.println("Software Engineer Resumes:");
        Resume.displayResumes(softwareEngineerResumes.getResumes());

        System.out.println("\nData Scientist Resumes:");
        Resume.displayResumes(dataScientistResumes.getResumes());

        System.out.println("\nProduct Manager Resumes:");
        Resume.displayResumes(productManagerResumes.getResumes());
    }
}