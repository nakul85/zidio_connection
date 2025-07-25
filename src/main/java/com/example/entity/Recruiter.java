package com.example.entity;

import jakarta.persistence.Entity;

@Entity
public class Recruiter extends User {

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}