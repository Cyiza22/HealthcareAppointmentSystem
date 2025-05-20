package org.example;

public class Marks {
    private int studentId;
    private int courseId;
    private float marks;

    // Constructors

    public Marks(int studentId, int courseId, float marks) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.marks = marks;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }
    public int getCourseId() {
        return courseId;
    }
    public float getMarks() {
        return marks;
    }

    // toString
    @Override
    public String toString() {
        return "Mark [studentId=" + studentId + ", courseId=" + courseId + ", marks=" + marks + "]";
    }
}

