import dao.StudentDAO;
import model.Student;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();

            // Create new student
            Student student = new Student();
            student.setName("Nadeem");
            student.setAddress("Cairo");
            student.setAge(21);
            student.setJoinedDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-09-01"));

            dao.createStudent(student);
            Long generatedId = student.getId(); // Get auto-generated ID

            // Get all students
            System.out.println("==== All Students ====");
            List<Student> students = dao.getAllStudents();
            for (Student s : students) {
                System.out.println(s.getId() + ": " + s.getName());
            }

            // Get student by ID
            System.out.println("\n==== Student by ID ====");
            Student s = dao.getStudentById(generatedId);
            if (s != null) {
                System.out.println("Found: " + s.getName());

                // Update student
                s.setAddress("Alexandria");
                dao.updateStudent(s);
                System.out.println("Updated address: " + dao.getStudentById(generatedId).getAddress());

                // Delete student
                dao.deleteStudent(generatedId);
                System.out.println("Deletion status: " +
                        (dao.getStudentById(generatedId) == null ? "Success" : "Failed"));
            }

            dao.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}