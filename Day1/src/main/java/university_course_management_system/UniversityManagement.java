package university_course_management_system;

import java.util.*;

// Abstract class representing a course type
abstract class CourseType {
    private String courseName;
    private int duration; // in weeks

    public CourseType(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", Duration: " + duration + " weeks";
    }
}

// Specific Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, int duration) {
        super(courseName, duration);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, int duration) {
        super(courseName, duration);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, int duration) {
        super(courseName, duration);
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public void removeCourse(T course) {
        courseList.remove(course);
    }

    public List<T> getCourses() {
        return courseList;
    }

    // Wildcard method to display any type of course
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

// Main class to test the University Course Management System
public class UniversityManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourseCatalog = new Course<>();
        Course<AssignmentCourse> assignmentCourseCatalog = new Course<>();
        Course<ResearchCourse> researchCourseCatalog = new Course<>();

        // Adding courses
        examCourseCatalog.addCourse(new ExamCourse("Mathematics", 12));
        examCourseCatalog.addCourse(new ExamCourse("Physics", 10));

        assignmentCourseCatalog.addCourse(new AssignmentCourse("Creative Writing", 8));
        assignmentCourseCatalog.addCourse(new AssignmentCourse("Digital Marketing", 6));

        researchCourseCatalog.addCourse(new ResearchCourse("AI and ML Research", 16));
        researchCourseCatalog.addCourse(new ResearchCourse("Quantum Computing", 20));

        // Displaying courses
        System.out.println("Exam-Based Courses:");
        Course.displayCourses(examCourseCatalog.getCourses());

        System.out.println("\nAssignment-Based Courses:");
        Course.displayCourses(assignmentCourseCatalog.getCourses());

        System.out.println("\nResearch-Based Courses:");
        Course.displayCourses(researchCourseCatalog.getCourses());
    }
}