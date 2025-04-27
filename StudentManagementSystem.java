import java.util.*;

public class StudentManagementSystem {
    private List<Student> studentList;
    private Scanner scanner;

    // Constructor
    public StudentManagementSystem() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a new student
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        Student student = new Student(id, name, age, department);
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    // Update student information
    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            student.setName(name);
            System.out.print("Enter new Age: ");
            int age = scanner.nextInt();
            student.setAge(age);
            scanner.nextLine();  // Consume the newline
            System.out.print("Enter new Department: ");
            String department = scanner.nextLine();
            student.setDepartment(department);

            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Delete a student
    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            studentList.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // View all students
    public void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentList) {
                student.displayStudent();
                System.out.println();
            }
        }
    }

    // Helper function to find student by ID
    private Student findStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Return null if student is not found
    }

    // Main menu
    public void menu() {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewStudents();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}
