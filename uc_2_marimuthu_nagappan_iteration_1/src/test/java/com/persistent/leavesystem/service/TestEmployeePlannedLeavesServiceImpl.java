package com.persistent.leavesystem.service;

import com.persistent.leavesystem.entity.EmployeePlannedLeaves;
import com.persistent.leavesystem.repository.EmployeePlannedLeavesRepository;
import com.persistent.leavesystem.service.impl.EmployeePlannedLeavesServiceImpl;
import com.persistent.leavesystem.service.impl.EmployeePlannedLeavesUploadHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Write test class for EmployeePlannedLeavesServiceImpl
@SpringBootTest
class TestEmployeePlannedLeavesServiceImpl {
    @Autowired
    EmployeePlannedLeavesUploadHelper employeePlannedLeavesUploadHelper;

    @Autowired
    EmployeePlannedLeavesServiceImpl employeePlannedLeavesService;

    @MockBean
    EmployeePlannedLeavesRepository employeePlannedLeavesRepository;

    //Write a test method for fetch all planned leaves by fetchAllPlannedLeaves
    @Test
    void fetchEmployeesAllPlannedLeaves() {
        List<EmployeePlannedLeaves> plannedLeavesList = new ArrayList<EmployeePlannedLeaves>();
        EmployeePlannedLeaves employeePlannedLeaves = new EmployeePlannedLeaves();
        employeePlannedLeaves.setEmployeeId(1);
        employeePlannedLeaves.setEmployeeDesignation("JavaLead");
        employeePlannedLeaves.setEmployeeLeaveCount(5);
        employeePlannedLeaves.setEmployeeFirstName("Raj");
        employeePlannedLeaves.setEmployeeLastName("Kiran");
        employeePlannedLeaves.setEmployeeLeaveEndDate(LocalDate.now());
        employeePlannedLeaves.setEmployeeLeaveStartDate(LocalDate.now().minusDays(2));
        employeePlannedLeaves.setEmployeePhone(9789912345L);
        employeePlannedLeaves.setEmployeeMiddleName("Shetty");
        plannedLeavesList.add(employeePlannedLeaves);
        Mockito.when(employeePlannedLeavesRepository.findAll()).thenReturn(plannedLeavesList);
        Assertions.assertEquals(plannedLeavesList,employeePlannedLeavesService.fetchEmployeesPlannedLeaves());
    }

    // Test fetchByEmail
    @Test
    void fetchEmployeePlannedLeavesByEmailId() {
        List<EmployeePlannedLeaves> plannedLeavesList = new ArrayList<EmployeePlannedLeaves>();
        EmployeePlannedLeaves employeePlannedLeaves = new EmployeePlannedLeaves();
        employeePlannedLeaves.setEmployeeId(1);
        employeePlannedLeaves.setEmployeeDesignation("JavaLead");
        employeePlannedLeaves.setEmployeeLeaveCount(5);
        employeePlannedLeaves.setEmployeeFirstName("Raj");
        employeePlannedLeaves.setEmployeeLastName("Kiran");
        employeePlannedLeaves.setEmployeeLeaveEndDate(LocalDate.now());
        employeePlannedLeaves.setEmployeeLeaveStartDate(LocalDate.now().minusDays(2));
        employeePlannedLeaves.setEmployeePhone(9789912345L);
        employeePlannedLeaves.setEmployeeMiddleName("Shetty");
        plannedLeavesList.add(employeePlannedLeaves);
        Mockito.when(employeePlannedLeavesRepository.findByEmployeeEmailId("test@gmail.com")).thenReturn(plannedLeavesList);
        assertEquals(plannedLeavesList,employeePlannedLeavesService.fetchEmployeesPlannedLeavesByEmployeeEmailId("test@gmail.com"));
    }

    //Write test class method for uploadExcelFileIntoDB
    @Test
    void uploadExcelFileIntoDB() {
        String path = "C:\\Users\\marimuthu_nagappan\\Downloads\\Book1.xlsx";
        File file = new File(path);
        try {
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(
                    file.getName(),
                    file.getName(),
                    "application/vnd.ms-excel",
                    input
            );
            employeePlannedLeavesUploadHelper.uploadExcelFileForEmployeePlannedLeaves(multipartFile.getInputStream());
            String result = employeePlannedLeavesService.uploadEmployeesPlannedLeaves(multipartFile);
            assertEquals(result,"Saved Successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}