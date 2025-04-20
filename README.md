# 🙎Student Management System using Java and JDBC🙎‍♀️

This is a simple **Student Management System** built using Java and JDBC. It allows basic CRUD operations on student data stored in a relational database like MySQL, including a search feature to quickly look up students by name or other attributes.

## 📁 Project Structure

```
src/
├── myPackage/
│   ├── App.java # Main entry point
│   ├── DB.java # Database connection logic
│   ├── Query.java # SQL query templates
│   ├── Student.java # Student model class
│   │── StudentDao.java # DAO class for handling student dat
├── bin/ # Compiled .class files
├── .classpath # Eclipse classpath configuration
├── .project # Eclipse project metadata
```
## 🛠 Technologies Used

- Java (Core)
- JDBC (Java Database Connectivity)
- MySQL (or any relational DB)
- Eclipse IDE

## 🚀 How to Run

1. **Clone this repository**

bash
git clone [https://github.com/SanketChopade777/Student-Management-System-using-Java-and-JDBC]

2. **Open the project in Eclipse**

Go to File > Import > Existing Projects into Workspace

3. **Setup your database**

4. **Create a student table in MySQL.**

Example:

```sql []

CREATE TABLE student (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
age INT,
course VARCHAR(100)
);

```

5. **Update your DB credentials in DB.java accordingly.**

6. **Run `App.java` to launch the application**

## 🔧 Features

- ➕ Add a new student

- 📋 View all student records

- ✏️ Update student details

- ❌ Delete a student record

- 🔍 Search student by name or other details

## 🙌 Contribution

Feel free to fork the project and raise pull requests.

## 📜 License

This project is licensed under the MIT License.

Developed by 👨‍💻 Sanket Chopade :)
