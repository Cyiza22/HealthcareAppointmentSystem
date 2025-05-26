package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRepository studentRepository = new  StudentRepository();
        CoursesRepository coursesRepository = new CoursesRepository();
        MarksRepository marksRepository = new MarksRepository();

        while (true) {

            System.out.println("a. Add Student");
            System.out.println("b. View Student");
            System.out.println("c. Update Student");
            System.out.println("d. Delete Student");
            System.out.println("e. Add Course");
            System.out.println("f. Get All Courses");
            System.out.println("g. View Course");
            System.out.println("h. Update Course");
            System.out.println("i. Delete Course");
            System.out.println("j. Add Mark");
            System.out.println("k. View Student Marks");
            System.out.println("l. Update Student Mark in Course");
            System.out.println("m. Delete Student Mark in Course");
            System.out.println("n. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    System.out.print("First Name: ");
                    String fn = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String ln = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Date of Birth (yyyy-mm-dd): ");
                    LocalDate dob = LocalDate.parse(scanner.nextLine());

                    Students student = new Students(0, fn, ln, email, String DateofB );
                    studentRepository.create(student);
                    System.out.println("Student added.");
                    break;

                case "b":
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Students s = studentRepository.findById(id);
                    System.out.println(s != null ? s : "Student not found.");
                    break;

                case "c":
                    System.out.print("Student ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Email: ");
                    String newEmail = scanner.nextLine();
                    Students updatedStudent = studentRepository.findById(updateId);
                    if (updatedStudent != null) {
                        updatedStudent.getEmail ();
                        studentRepository.update(updatedStudent, updateId);
                        System.out.println("Student updated.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case "d":
                    System.out.print("Student ID to delete: ");
                    int delId = Integer.parseInt(scanner.nextLine());
                    studentRepository.deleteById(delId);
                    System.out.println("Student deleted.");
                    break;

                case "e":
                    System.out.print("Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();

                    Courses course = new Courses(0, courseName, desc);
                    coursesRepository.create(course);
                    System.out.println("Course added.");
                    break;

                case "f":
                    List<Courses> courses = coursesRepository.findAll();
                    courses.forEach(System.out::println);
                    break;

                case "g":
                    System.out.print("Enter Course ID: ");
                    int courseId = Integer.parseInt(scanner.nextLine());
                    Courses c = coursesRepository.findById(courseId);
                    System.out.println(c != null ? c : "Course not found.");
                    break;

                case "h":
                    System.out.print("Course ID to update: ");
                    int updateCourseId = Integer.parseInt(scanner.nextLine());
                    Courses courseToUpdate = coursesRepository.findById(updateCourseId);
                    if (courseToUpdate != null) {
                        System.out.print("New Name: ");
                        courseToUpdate.getCourseName();
                        System.out.print("New Description: ");
                        courseToUpdate.getCourseDescription();
                        coursesRepository.update(courseToUpdate, updateCourseId);
                        System.out.println("Course updated.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case "i":
                    System.out.print("Course ID to delete: ");
                    int delCourseId = Integer.parseInt(scanner.nextLine());
                    coursesRepository.deleteById(delCourseId);
                    System.out.println("Course deleted.");
                    break;

                case "j":
                    System.out.print("Student ID: ");
                    int sid = Integer.parseInt(scanner.nextLine());
                    System.out.print("Course ID: ");
                    int cid = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mark: ");
                    float mark = Float.parseFloat(scanner.nextLine());
                    marksRepository.create(new Marks(sid, cid, mark));
                    System.out.println("Mark added.");
                    break;

                case "k":
                    System.out.print("Enter Student ID: ");
                    int studId = Integer.parseInt(scanner.nextLine());
                    List<Marks> studentMarks = marksRepository.findByStudentAndCourse(int studid);
                    studentMarks.forEach(System.out::println);
                    break;

                case "l":
                    System.out.print("Student ID: ");
                    int stId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Course ID: ");
                    int coId = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Mark: ");
                    float newMark = Float.parseFloat(scanner.nextLine());
                    marksRepository.update(new Marks(stId, coId, newMark), stId); // You can adapt this
                    System.out.println("Mark updated.");
                    break;

                case "m":
                    System.out.print("Student ID: ");
                    int stuId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Course ID: ");
                    int crId = Integer.parseInt(scanner.nextLine());
                    marksRepository.deleteById (stuId id, crId);
                    System.out.println("Mark deleted.");
                    break;

                case "n":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

