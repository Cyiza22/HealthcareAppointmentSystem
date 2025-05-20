package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepository implements Repository<Courses, Integer> {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Rwanda";

    // 1. Connect to DB
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 2. Get all courses
    @Override
    public List<Courses> findAll() {
        List<Courses> courses = new ArrayList<>();
        String query = "SELECT id, name, description FROM courses";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                courses.add(new Courses(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching courses: " + e.getMessage());
        }

        return courses;
    }

    // 3. Find course by ID
    @Override
    public Courses findById(Integer id) {
        String query = "SELECT id, name, description FROM courses WHERE id = ?";
        Courses course = null;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                course = new Courses(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error finding course: " + e.getMessage());
        }
        return course;
    }

    // 4. Create new course
    @Override
    public void create(Courses course) {
        String query = "INSERT INTO courses (name, description) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getCourseDescription());

            pstmt.executeUpdate();
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    // 5. Update course by id
    @Override
    public void update(Courses course, Integer id) {
        String query = "UPDATE courses SET name = ?, description = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getCourseDescription());
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Course updated successfully!");
            } else {
                System.out.println("No course found with id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error updating course: " + e.getMessage());
        }
    }

    // 6. Delete course by id
    @Override
    public void deleteById(Integer id) {
        String query = "DELETE FROM courses WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("No course found with id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting course: " + e.getMessage());
        }
    }
}

