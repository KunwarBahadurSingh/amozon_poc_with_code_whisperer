package com.persistent.jobs.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

//create a class for JobsAPI entity
@Entity
@Table(name = "Jobs_API")
public class JobsAPI {
    //create fields like jobsId, jobsSkills, jobsDescription, jobsLocation, jobsPostedDate, jobsTitle, company
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobsId;
    private String jobsSkills;
    private String jobsDescription;
    private String jobsLocation;
    private LocalDate jobsPostedDate;
    private String jobsTitle;
    private String company;
    //Generate setter and getter of above fields
    public Long getJobsId() {
        return jobsId;
    }

    public void setJobsId(Long jobsId) {
        this.jobsId = jobsId;
    }

    public String getJobsSkills() {
        return jobsSkills;
    }

    public void setJobsSkills(String jobsSkills) {
        this.jobsSkills = jobsSkills;
    }

    public String getJobsDescription() {
        return jobsDescription;
    }

    public void setJobsDescription(String jobsDescription) {
        this.jobsDescription = jobsDescription;
    }

    public String getJobsLocation() {
        return jobsLocation;
    }

    public void setJobsLocation(String jobsLocation) {
        this.jobsLocation = jobsLocation;
    }

    public LocalDate getJobsPostedDate() {
        return jobsPostedDate;
    }

    public void setJobsPostedDate(LocalDate jobsPostedDate) {
        this.jobsPostedDate = jobsPostedDate;
    }

    public String getJobsTitle() {
        return jobsTitle;
    }

    public void setJobsTitle(String jobsTitle) {
        this.jobsTitle = jobsTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
