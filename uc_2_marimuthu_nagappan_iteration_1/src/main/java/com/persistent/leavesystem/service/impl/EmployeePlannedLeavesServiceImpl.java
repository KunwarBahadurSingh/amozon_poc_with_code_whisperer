package com.persistent.leavesystem.service.impl;

import com.persistent.leavesystem.entity.EmployeePlannedLeaves;
import com.persistent.leavesystem.repository.EmployeePlannedLeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

//create class for EmployeePlannedLeavesServiceImpl
@Service
public class EmployeePlannedLeavesServiceImpl {
    @Autowired
    private EmployeePlannedLeavesRepository employeePlannedLeavesRepository;
    @Autowired
    private EmployeePlannedLeavesUploadHelper employeePlannedLeavesUploadHelper;

    //create a method to upload of employee planned leaves
    public String uploadEmployeesPlannedLeaves(MultipartFile leaveDetails) throws IOException {
        //convert the multipart file to leave details
        employeePlannedLeavesUploadHelper.uploadExcelFileForEmployeePlannedLeaves(leaveDetails.getInputStream());
        return "Saved Successfully";
    }
    //create a method for  fetch Planned Leaves of all employees
    public List<EmployeePlannedLeaves> fetchEmployeesPlannedLeaves() {
        return employeePlannedLeavesRepository.findAll();
    }

    //create a method for fetching planned leaves by employee email id
    public List<EmployeePlannedLeaves> fetchEmployeesPlannedLeavesByEmployeeEmailId(String employeeEmailId) {
        return employeePlannedLeavesRepository.findByEmployeeEmailId(employeeEmailId);
    }
}
