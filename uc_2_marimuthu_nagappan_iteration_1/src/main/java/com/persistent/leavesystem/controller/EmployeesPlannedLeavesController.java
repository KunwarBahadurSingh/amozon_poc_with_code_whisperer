package com.persistent.leavesystem.controller;
//create controller for EmployeePlannedLeaves
import com.persistent.leavesystem.entity.EmployeePlannedLeaves;
import com.persistent.leavesystem.service.impl.EmployeePlannedLeavesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v2/els")
public class EmployeesPlannedLeavesController {
     @Autowired
     private EmployeePlannedLeavesServiceImpl employeePlannedLeavesServiceImpl;
    //upload employee planned leaves for excel sheet
    @PostMapping(path= "/uploadLeaveDetails", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String uploadEmployeePlannedLeavesDet(@RequestBody MultipartFile leaveDetails) throws IOException {
       return employeePlannedLeavesServiceImpl.uploadEmployeesPlannedLeaves(leaveDetails);
    }

    //retrieve employee planned leaves for all employees
    @GetMapping("/getAll")
    public List<EmployeePlannedLeaves> retEmployeePlannedLeaves() {
        return employeePlannedLeavesServiceImpl.fetchEmployeesPlannedLeaves();
    }

    //retrieve employee planned leaves by employee email id
    @GetMapping("/getLeaveDetails/{employeeEmailId}")
    public List<EmployeePlannedLeaves> retEmployeePlannedLeavesbyEmailId(@PathVariable("employeeEmailId") String employeeEmailId) {
        return employeePlannedLeavesServiceImpl.fetchEmployeesPlannedLeavesByEmployeeEmailId(employeeEmailId);
    }
}
