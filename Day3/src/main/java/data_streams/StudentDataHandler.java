package data_streams;

import java.io.*;

public class StudentDataHandler {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Store student details
        storeStudentData();

        // Retrieve and display student details
        retrieveStudentData();
    }

    private static void storeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);

            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Retrieved Student Data:");

            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}