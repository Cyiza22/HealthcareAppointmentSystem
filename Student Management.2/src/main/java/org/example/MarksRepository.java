package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksRepository implements Repository<Marks, Integer> {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Override
    public List<Marks> findAll() {
        List<Marks> marks = new ArrayList<>();
        String query = "SELECT * FROM marks";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                marks.add(new Marks(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getFloat("marks")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving marks: " + e.getMessage());
        }

        return marks;
    }

    @Override
    public Marks findById(Integer id) {

        return null;
    }

    public Marks findByStudentAndCourse(int studentId, int courseId) {
        String query = "SELECT * FROM marks WHERE student_id = ? AND course_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Marks(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getFloat("marks")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error finding mark: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void deleteById(Integer id) {
        // Use deleteByStudentAndCourse instead
    }

    public void deleteByStudentAndCourse(int studentId, int courseId) {
        String query = "DELETE FROM marks WHERE student_id = ? AND course_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();
            System.out.println("Mark deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting mark: " + e.getMessage());
        }
    }

    @Override
    public void create(Marks mark) {
        String query = "INSERT INTO marks(student_id, course_id, marks) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, mark.getStudentId());
            stmt.setInt(2, mark.getCourseId());
            stmt.setFloat(3, mark.getMarks());
            stmt.executeUpdate();
            System.out.println("Mark inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting mark: " + e.getMessage());
        }
    }

    @Override
    public void update(Marks mark, Integer unused) {
        String query = "UPDATE marks SET marks = ? WHERE student_id = ? AND course_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setFloat(1, mark.getMarks());
            stmt.setInt(2, mark.getStudentId());
            stmt.setInt(3, mark.getCourseId());
            stmt.executeUpdate();
            System.out.println("Mark updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating mark: " + e.getMessage());
        }
    }
}
