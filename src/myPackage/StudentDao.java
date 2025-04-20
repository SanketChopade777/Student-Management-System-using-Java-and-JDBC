package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	public static void createStudent(Student student) {
        try (Connection con = DB.connect();
             PreparedStatement preparedStatement = con.prepareStatement(Query.insert)) {
            preparedStatement.setInt(1, student.getSid());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getGrade());
            preparedStatement.executeUpdate();
            System.out.println("Student created successfully.");
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Duplicate entry for SID. Please use a unique SID.");
            } else if (e.getErrorCode() == 1265) {
                System.out.println("Error: Please provide a valid grade ('A' to 'F').");
            } else {
                System.out.println("Error creating student: " + e.getMessage());
            }
        }
    }

    public static ArrayList<Student> readAllStudents() {
        ArrayList<Student> stdList = new ArrayList<>();
        try (Connection con = DB.connect();
             PreparedStatement preparedStatement = con.prepareStatement(Query.select)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student std = new Student(rs.getInt("sid"), rs.getString("name"), rs.getString("grade"));
                stdList.add(std);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stdList;
    }

    public static String formatStudentsToTable(ArrayList<Student> students) {
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

    public static ArrayList<Student> searchStudentBySid(int sid) {
        ArrayList<Student> resultList = new ArrayList<>();

        try (Connection con = DB.connect();
             PreparedStatement preparedStatement = con.prepareStatement(Query.searchBySid)) {

            preparedStatement.setInt(1, sid);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt("sid"), rs.getString("name"), rs.getString("grade"));
                resultList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while searching for student by SID: " + e.getMessage());
        }

        return resultList;
    }

    public static ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> resultList = new ArrayList<>();

        try (Connection con = DB.connect();
             PreparedStatement preparedStatement = con.prepareStatement(Query.searchByName)) {

            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt("sid"), rs.getString("name"), rs.getString("grade"));
                resultList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while searching for student by name: " + e.getMessage());
        }

        return resultList;
    }

    public static ArrayList<Student> searchStudentByGrade(String grade) {
        ArrayList<Student> resultList = new ArrayList<>();

        try (Connection con = DB.connect();
             PreparedStatement preparedStatement = con.prepareStatement(Query.searchByGrade)) {

            preparedStatement.setString(1, grade);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student student = new Student(rs.getInt("sid"), rs.getString("name"), rs.getString("grade"));
                resultList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while searching for student by grade: " + e.getMessage());
        }

        return resultList;
    }

    public static boolean updateStudent(int sid, String newName) {
        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(Query.update)) {
            ps.setString(1, newName);
            ps.setInt(2, sid);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteStudent(int sid) {
        try (Connection conn = DB.connect();
             PreparedStatement ps = conn.prepareStatement(Query.delete)) {
            ps.setInt(1, sid);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
