package myPackage;

public class Student {
    private int sid;
    private String name;
    private String grade;

    public Student(int sid, String name, String grade) {
        this.sid = sid;
        this.name = name;
        this.grade = grade;
    }

    public int getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student [Sid=" + sid + ", Name=" + name + ", Grade=" + grade + "]";
    }
}

