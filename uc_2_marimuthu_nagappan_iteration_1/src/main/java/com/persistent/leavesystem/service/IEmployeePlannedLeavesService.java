package com.persistent.leavesystem.service;

import com.persistent.leavesystem.entity.EmployeePlannedLeaves;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

//create interface for EmployeePlannedLeavesService
public interface IEmployeePlannedLeavesService {
    //create a method for saving EmployeePlannedLeaves through Excel sheet upload
    public String uploadEmployeesPlannedLeaves(MultipartFile leaveDetails) throws IOException;

    //create a method for  fetch Planned Leaves of all employees
    public List<EmployeePlannedLeaves> fetchEmployeesPlannedLeaves();

    //create a method for fetching planned leaves by employee email id
    public List<EmployeePlannedLeaves> fetchEmployeesPlannedLeavesByEmployeeEmailId(String employeeEmail);
}
