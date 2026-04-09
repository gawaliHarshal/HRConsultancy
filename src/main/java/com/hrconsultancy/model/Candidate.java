package com.hrconsultancy.model;

import java.sql.Timestamp;

public class Candidate {
    
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String qualification;
    private int experienceYears;
    private String skills;
    private Timestamp createdAt;

    public Candidate() {
    }

    public Candidate(String fullName, String email, String phone, String qualification, int experienceYears, String skills) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}