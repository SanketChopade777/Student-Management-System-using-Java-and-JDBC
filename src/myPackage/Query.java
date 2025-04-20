package myPackage;

public class Query {
    static String insert = "INSERT INTO student (sid, name, grade) VALUES (?, ?, ?)";
    static String update = "UPDATE student SET name = ? WHERE sid = ?";
    static String delete = "DELETE FROM student WHERE sid = ?";
    static String select = "SELECT * FROM student";
    static String searchByName = "SELECT * FROM student WHERE name = ?";
    static String searchBySid = "SELECT * FROM student WHERE sid = ?";
    static String searchByGrade = "SELECT * FROM student WHERE grade = ?";
    static String selectByName = "SELECT sid, name, grade FROM student WHERE name = ?";
}
