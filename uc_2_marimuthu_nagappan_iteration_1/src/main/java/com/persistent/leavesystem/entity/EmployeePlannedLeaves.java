package com.persistent.leavesystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
//create entity class for employee planned leaves
@Entity
@Table(name="employee_planned_leaves")
public class EmployeePlannedLeaves {
    @Id
    @Column(updatable = false)
    @GeneratedValue
    private Integer employeeId;
    @NotNull
    private LocalDate employeeLeaveStartDate;
    @NotNull
    private LocalDate employeeLeaveEndDate;
    private int employeeLeaveCount;
    @NotNull
    private String employeeFirstName;
    private String employeeMiddleName;
    @NotNull
    private String employeeLastName;
    @NotNull
    private String employeeEmailId;
    @NotNull
    private Long employeePhone;
    @NotNull
    private String employeeDesignation;

    @NotNull
    private String employeeLocation;
    //create setter and getter for above fields
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public LocalDate getEmployeeLeaveStartDate() {
        return employeeLeaveStartDate;
    }
    public void setEmployeeLeaveStartDate(LocalDate employeeLeaveStartDate) {
        this.employeeLeaveStartDate = employeeLeaveStartDate;
    }
    public LocalDate getEmployeeLeaveEndDate() {
         return employeeLeaveEndDate;
    }
    public void setEmployeeLeaveEndDate(LocalDate employeeLeaveEndDate) {
        this.employeeLeaveEndDate = employeeLeaveEndDate;
    }
    public int getEmployeeLeaveCount() {
        return employeeLeaveCount;
    }
    public void setEmployeeLeaveCount(int employeeLeaveCount) {
        this.employeeLeaveCount = employeeLeaveCount;
    }
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }
    public String setEmployeeMiddleName() {
        return employeeMiddleName;
    }
    public void setEmployeeMiddleName(String employeeMiddleName) {
        this.employeeMiddleName = employeeMiddleName;
    }
    public String getEmployeeLastName() {
        return employeeLastName;
    }
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }
    public String getEmployeeEmailId() {
        return employeeEmailId;
    }
    public void setEmployeeEmailId(String employeeEmailId) {
        this.employeeEmailId = employeeEmailId;
    }
    public Long getEmployeePhone() {
        return employeePhone;
    }
    public void setEmployeePhone(Long employeePhone) {
        this.employeePhone = employeePhone;
    }
    public String getEmployeeDesignation() {
        return employeeDesignation;
    }
    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }
    public String getEmployeeLocation() {
        return employeeLocation;
    }
    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation;
    }
    public EmployeePlannedLeaves() {}
}
