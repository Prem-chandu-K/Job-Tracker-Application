package com.SpringBoot.JobTracker.Model;

import java.time.LocalDate;

import com.SpringBoot.JobTracker.Enums.JobStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "job_application")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private LocalDate appliedDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStatus status;

    private LocalDate interviewDate;

    @Column(length = 500)
    private String notes;

    //Default constructor 
    public JobApplication() {
        this.appliedDate = LocalDate.now();
    }

    //Parameterized constructor
    public JobApplication(Long id, String companyName, String position,
                          LocalDate appliedDate, JobStatus status,
                          LocalDate interviewDate, String notes) {
        this.id = id;
        this.companyName = companyName;
        this.position = position;
        this.appliedDate = appliedDate;
        this.status = status;
        this.interviewDate = interviewDate;
        this.notes = notes;
    }

    // ✅ Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
