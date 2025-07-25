package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

@Entity
public class Student extends User {

    private String fieldOfStudy;

    @Lob
    private byte[] resume;

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }
}