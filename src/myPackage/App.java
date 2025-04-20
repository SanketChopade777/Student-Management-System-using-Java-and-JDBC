package myPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management: ");
            System.out.println("1 = Insert , 2 = Read, 3 = Update, 4 = Delete, 5 = Search ,6 = Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character after reading int

            if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter sid, name, grade: ");
                    int sid = sc.nextInt();
                    sc.nextLine(); // Consume newline character after reading int
                    String name = sc.nextLine();
                    String grade = sc.nextLine();
                    Student std = new Student(sid, name, grade);
                    StudentDao.createStudent(std);
                    break;

                case 2:
                    ArrayList<Student> allStudents = StudentDao.readAllStudents();
                    String formattedStudents = formatStudentsToTable(allStudents);
                    System.out.println("List of students:");
                    System.out.println(formattedStudents);
                    break;

                case 3:
                    System.out.print("Enter sid and new name: ");
                    int sidToUpdate = sc.nextInt();
                    sc.nextLine(); // Consume newline character after reading int
                    String newName = sc.nextLine();
                    boolean updated = StudentDao.updateStudent(sidToUpdate, newName);
                    if (updated) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found or update failed.");
                    }
                    break;

                case 4:
                    System.out.print("Enter sid to delete: ");
                    int sidToDelete = sc.nextInt();
                    boolean deleted = StudentDao.deleteStudent(sidToDelete);
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found or delete failed.");
                    }
                    break;

                case 5:
                    System.out.println("Search by: ");
                    System.out.println("1 = SID, 2 = Name, 3 = Grade");
                    System.out.print("Enter search option: ");
                    int searchOption = sc.nextInt();
                    sc.nextLine(); // Consume newline character after reading int

                    switch (searchOption) {
                        case 1:
                            System.out.print("Enter SID: ");
                            int searchSid = sc.nextInt();
                            ArrayList<Student> studentsBySid = StudentDao.searchStudentBySid(searchSid);
                            String formattedSidSearch = formatStudentsToTable(studentsBySid);
                            System.out.println("Search results by SID:");
                            System.out.println(formattedSidSearch);
                            break;
                        case 2:
                            System.out.print("Enter Name: ");
                            String searchName = sc.nextLine();
                            ArrayList<Student> studentsByName = StudentDao.searchStudentByName(searchName);
                            String formattedNameSearch = formatStudentsToTable(studentsByName);
                            System.out.println("Search results by Name:");
                            System.out.println(formattedNameSearch);
                            break;
                        case 3:
                            System.out.print("Enter Grade: ");
                            String searchGrade = sc.nextLine();
                            ArrayList<Student> studentsByGrade = StudentDao.searchStudentByGrade(searchGrade);
                            String formattedGradeSearch = formatStudentsToTable(studentsByGrade);
                            System.out.println("Search results by Grade:");
                            System.out.println(formattedGradeSearch);
                            break;
                        default:
                            System.out.println("Invalid search option.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Enter valid choice between 1-6.");
                    break;
            }
        }

        sc.close(); // Close Scanner to avoid resource leak
    }

    private static String formatStudentsToTable(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return "No students found.";
        }

        StringBuilder table = new StringBuilder();
        table.append("+-----+----------------------+-------+\n");
        table.append("| SID | Name                 | Grade |\n");
        table.append("+-----+----------------------+-------+\n");

        for (Student student : students) {
            table.append(String.format("| %-3d | %-20s | %-5s |\n",
                    student.getSid(), student.getName(), student.getGrade()));
        }

        table.append("+-----+----------------------+-------+\n");
        return table.toString();
    }
}
