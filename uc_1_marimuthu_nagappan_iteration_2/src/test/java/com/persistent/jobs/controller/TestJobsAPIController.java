package com.persistent.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistent.jobs.service.impl.JobsAPIServiceImpl;
import com.persistent.jobs.entity.JobsAPI;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Write a Unit test for JobsAPIController class
@WebMvcTest(JobsAPIController.class)
public class TestJobsAPIController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobsAPIServiceImpl jobsAPIServiceImpl;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //write a unit test for saveJobs method
    @Test
    public void testSaveJobs() throws Exception {
        JobsAPI jobsAPI = new JobsAPI();
        jobsAPI.setJobsId(1L);
        jobsAPI.setJobsTitle("Java");
        jobsAPI.setJobsLocation("Bengaluru");
        jobsAPI.setJobsSkills("JavaSpringBoot");
        jobsAPI.setCompany("Persistent");
        jobsAPI.setJobsDescription("Lead Developer");
        given(jobsAPIServiceImpl.saveJobsAPI(jobsAPI)).willReturn(jobsAPI);
        this.mockMvc.perform(post("/api/v4/jobsAPI/saveJobs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(jobsAPI))
            ).andExpect(status().isCreated());
    }

    @Test
    public void testSaveAllJobs() throws Exception {
        List<JobsAPI> jobsList = new ArrayList<>();
        JobsAPI jobs = new JobsAPI();
        jobs.setJobsId(1L);
        jobs.setJobsTitle("Java");
        jobs.setJobsLocation("Bengaluru");
        jobs.setJobsSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        jobsList.add(jobs);
        given(jobsAPIServiceImpl.saveAllJobsAPI(jobsList)).willReturn(jobsList);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v4/jobsAPI/saveAllJobs")
                        .content(asJsonString(jobsList))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
