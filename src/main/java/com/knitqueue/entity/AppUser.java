package com.knitqueue.entity;

import jakarta.persistence.*;

@Entity
@Table(name="app_user")
public class AppUser {
    // Fields
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="email")
    private String email;

    @Column(name="password_hash")
    private String passwordHash;

    @Column(name="first_name")
    private String firstName;

    // Constructors
    public AppUser() {}

    public AppUser(String email, String passwordHash, String firstName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // toString
    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
