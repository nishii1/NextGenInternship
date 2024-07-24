package Studentgrademanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Studentgrademanagementsystem {

    static List<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to Student Grade Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Add Grade for a Student");
            System.out.println("3. Calculate Average Grade for a Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    calculateAverageGrade();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Student Grade Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }

    public static void addNewStudent() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student '" + name + "' added successfully.");
    }

    public static void addGrade() {
        if (students.isEmpty()) {
            System.out.println("No students in the system. Add a student first.");
            return;
        }

        System.out.println("Select a student:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }

        int studentIndex = scanner.nextInt();
        scanner.nextLine();

        if (studentIndex >= 1 && studentIndex <= students.size()) {
            System.out.println("Enter grade:");
            double grade = scanner.nextDouble();
            students.get(studentIndex - 1).addGrade(grade);
            System.out.println("Grade '" + grade + "' added for student '" + students.get(studentIndex - 1).getName() + "'.");
        } else {
            System.out.println("Invalid input. Please enter a valid student number.");
        }
    }

    public static void calculateAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("Select a student:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }

        int studentIndex = scanner.nextInt();
        scanner.nextLine();

        if (studentIndex >= 1 && studentIndex <= students.size()) {
            double averageGrade = students.get(studentIndex - 1).calculateAverageGrade();
            System.out.println("Average grade for student '" + students.get(studentIndex - 1).getName() + "' is: " + averageGrade);
        } else {
            System.out.println("Invalid input. Please enter a valid student number.");
        }
    }

    public static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Grades: " + student.getGrades());
            System.out.println();
        }
    }
}

class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}
