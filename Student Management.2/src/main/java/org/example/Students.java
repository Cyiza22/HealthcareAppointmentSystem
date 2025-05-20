package org.example;

public class Students {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;

    public Students(int id, String firstName, String lastName, String email, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters only
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // toString
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + firstName + " " + lastName +
                ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
    }
}
