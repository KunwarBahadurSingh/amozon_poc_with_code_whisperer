package com.persistent.jobs.service.impl;

import com.persistent.jobs.entity.JobsAPI;
import com.persistent.jobs.repository.JobsAPIRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//create a unit test for JobsAPIServiceImpl class
@ExtendWith(MockitoExtension.class)
public class TestJobsAPIServiceImpl {
    @InjectMocks
    JobsAPIServiceImpl jobsAPIServiceImpl;

    @Mock
    JobsAPIRepository jobsAPIRepository;

    //write a test method for saveJobsAPI method
    @Test
    void testSaveJobsAPI() {
        JobsAPI jobsAPI = new JobsAPI();
        jobsAPI.setJobsId(1L);
        jobsAPI.setJobsTitle("Java");
        jobsAPI.setJobsLocation("Bengaluru");
        jobsAPI.setJobsSkills("JavaSpringBoot");
        jobsAPI.setCompany("Persistent");
        jobsAPI.setJobsDescription("Lead Developer");
        when(jobsAPIRepository.save(jobsAPI))
                .thenReturn(jobsAPI);
        JobsAPI jobsAPI1= jobsAPIServiceImpl.saveJobsAPI(jobsAPI);
        assertThat(jobsAPI).isNotNull();
        assertThat(jobsAPI1.getJobsId()).isEqualTo(1L);
    }

    //write a test method for saveAllJobsAPI method
    @Test
    void testSaveAllJobsAPI() {
        List<JobsAPI> allJobsAPI = new ArrayList<>();
        JobsAPI jobsAPI = new JobsAPI();
        jobsAPI.setJobsId(1L);
        jobsAPI.setJobsTitle("Java");
        jobsAPI.setJobsLocation("Bengaluru");
        jobsAPI.setJobsSkills("JavaSpringBoot");
        jobsAPI.setCompany("Persistent");
        jobsAPI.setJobsDescription("Lead Developer");
        allJobsAPI.add(jobsAPI);
        when(jobsAPIRepository.saveAll(allJobsAPI)).thenReturn(allJobsAPI);
        List<JobsAPI> jobsList = jobsAPIServiceImpl.saveAllJobsAPI(allJobsAPI);
        assertThat(jobsList).isNotNull();
        assertThat(jobsList.get(0).getJobsId()).isEqualTo(1L);
    }

}
