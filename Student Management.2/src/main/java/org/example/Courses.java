package org.example;

public class Courses {
    private int id;
    private String courseName;
    private String courseDescription;

    // Constructors

    public Courses(int id, String courseName, String courseDescription) {
        this.id = id;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    // toString
    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName +
                ", description=" + courseDescription + "]";
    }
}

