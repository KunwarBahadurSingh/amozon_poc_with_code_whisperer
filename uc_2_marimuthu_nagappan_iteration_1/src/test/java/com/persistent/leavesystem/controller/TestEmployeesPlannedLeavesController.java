package com.persistent.leavesystem.controller;

import com.persistent.leavesystem.entity.EmployeePlannedLeaves;
import com.persistent.leavesystem.service.impl.EmployeePlannedLeavesServiceImpl;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Write test class for EmployeesPlannedLeavesController
@SpringBootTest
class TestEmployeesPlannedLeavesController {
    @Autowired
    EmployeesPlannedLeavesController employeesPlannedLeavesController;

    @MockBean
    EmployeePlannedLeavesServiceImpl employeePlannedLeavesServiceImpl;

    //write a test method for retrieveAll leaves by retrieveAllLeaves
    @Test
    void retrieveAllLeaves() {
        List<EmployeePlannedLeaves> employeePlannedLeavesList = new ArrayList<EmployeePlannedLeaves>();
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
        employeePlannedLeavesList.add(employeePlannedLeaves);
        Mockito.when(employeePlannedLeavesServiceImpl.fetchEmployeesPlannedLeaves()).thenReturn(employeePlannedLeavesList);
        Assertions.assertEquals(employeePlannedLeavesList, employeesPlannedLeavesController.retEmployeePlannedLeaves());
    }

    //write a test method for fetchPlannedLeavesByEmail
    @Test
    void fetchPlannedLeavesByEmail() {
        List<EmployeePlannedLeaves> employeePlannedLeavesList = new ArrayList<EmployeePlannedLeaves>();
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
        employeePlannedLeaves.setEmployeeEmailId("test@gmail.com");
        employeePlannedLeaves.setEmployeeLocation("Bangalore");
        employeePlannedLeavesList.add(employeePlannedLeaves);
        Mockito.when(employeePlannedLeavesServiceImpl.fetchEmployeesPlannedLeavesByEmployeeEmailId(employeePlannedLeaves.getEmployeeEmailId())).thenReturn(employeePlannedLeavesList);
        Assertions.assertEquals(employeePlannedLeavesList, employeesPlannedLeavesController.retEmployeePlannedLeavesbyEmailId("test@gmail.com"));
        assertThat(employeePlannedLeaves.getEmployeeId()).isNotNull();
        assertThat(employeePlannedLeaves.getEmployeeLeaveCount()).isNotNull();
        assertThat(employeePlannedLeaves.getEmployeeLeaveStartDate()).isNotNull();
        assertThat(employeePlannedLeaves.getEmployeeLeaveEndDate()).isNotNull();
        assertThat(employeePlannedLeaves.getEmployeeEmailId()).isNotNull();
        assertThat(employeePlannedLeaves.getEmployeePhone()).isNotNull();
        assertThat(employeePlannedLeaves.getEmployeeLocation()).isNotNull();
        assertThat(employeePlannedLeaves.getEmployeeDesignation()).isNotNull();
    }

    //Write a test method for uploading uploadExcelFile
    @Test
    void uploadExcelFileIntoDBTbl() {
        String path = "C:\\Users\\marimuthu_nagappan\\Downloads\\Book1.xlsx";
        File file = new File(path);
        try {
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), "application/vnd.ms-excel", input);
            Mockito.when(employeePlannedLeavesServiceImpl.uploadEmployeesPlannedLeaves(multipartFile)).thenReturn("Saved Successfully.");
            String result = employeesPlannedLeavesController.uploadEmployeePlannedLeavesDet(multipartFile);
            assertEquals(result, "Saved Successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}