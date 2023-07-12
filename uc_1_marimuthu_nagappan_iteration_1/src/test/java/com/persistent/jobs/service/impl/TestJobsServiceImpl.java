package com.persistent.jobs.service.impl;

import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.repository.JobsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestJobsServiceImpl {
    @InjectMocks
    JobsServiceImpl jobsServiceImpl;

    @Mock
    JobsRepository jobsRepository;

    @Test
    void testSaveJobs() {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobDescription("Lead Developer");
        when(jobsRepository.save(jobs))
                .thenReturn(jobs);
        Jobs jobs1= jobsServiceImpl.saveJobs(jobs);
        assertThat(jobs).isNotNull();
        assertThat(jobs1.getJobId()).isEqualTo(1L);
    }

    @Test
    void testRetrieveAllJobs() {
        List<Jobs> allJobs = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobDescription("Lead Developer");
        when(jobsRepository.findAll()).thenReturn(List.of(jobs));
        List<Jobs> jobsList = jobsServiceImpl.retrieveAllJobs();
        assertThat(jobsList).isNotNull();
        assertThat(jobsList.get(0).getJobId()).isEqualTo(1L);
    }

    @Test
    void testDeleteJob() {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobDescription("Lead Developer");
        jobsRepository.save(jobs);
        jobsRepository.deleteById(jobs.getJobId());
        Optional<Jobs> jobsOptional = jobsRepository.findById(jobs.getJobId());
        assertThat(jobsOptional).isEmpty();
    }

    @Test
    void testSaveAllJobs() {
        List<Jobs> allJobs = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobDescription("Lead Developer");
        allJobs.add(jobs);
        when(jobsRepository.saveAll(allJobs)).thenReturn(allJobs);
        List<Jobs> jobsList = jobsServiceImpl.saveAllJobs(allJobs);
        assertThat(jobsList).isNotNull();
        assertThat(jobsList.get(0).getJobId()).isEqualTo(1L);
    }
}
