import dao.StudentDAO;
import model.Student;

import java.sql.Date;
import java.util.List;

public class TestStudentDAO {
    public static void main(String[] args) {
        testStudentDAOOperations();
    }
    public static void testStudentDAOOperations() {
        StudentDAO dao = new StudentDAO();

        System.out.println("===== Creating Student =====");
        Student student = new Student();
        student.setId(100);
        student.setName("Test User");
        student.setAddress("Test Address");
        student.setAge(20);
        student.setJoinedDate(Date.valueOf("2022-01-01"));
        dao.createStudent(student);

        System.out.println("===== Fetching All Students =====");
        List<Student> students = dao.getAllStudents();
        for (Student s : students) {
            System.out.println("Student: " + s.getId() + ", " + s.getName());
        }

        System.out.println("===== Fetching Student By ID =====");
        Student fetched = dao.getStudentById(100);
        System.out.println("Fetched: " + fetched.getName());

        System.out.println("===== Updating Student =====");
        fetched.setAddress("Updated Address");
        dao.updateStudent(fetched);
        System.out.println("Updated Address: " + dao.getStudentById(100).getAddress());

        System.out.println("===== Deleting Student =====");
        dao.deleteStudent(100);
        Student deleted = dao.getStudentById(100);
        System.out.println("Deleted student is: " + (deleted == null ? "null (success)" : "still exists"));
    }
}