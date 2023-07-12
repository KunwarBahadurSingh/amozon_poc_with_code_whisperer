package com.persistent.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.service.impl.JobsServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.hasSize;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JobsController.class)
public class TestJobsController {
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private JobsServiceImpl jobsService;

        @BeforeEach
        void setUp() {
        }

        @AfterEach
        void tearDown() {
        }

        @Test
        void testAddJob() throws Exception {
            Jobs jobs = new Jobs();
            jobs.setJobId(1L);
            jobs.setJobTitle("Java");
            jobs.setJobLocation("Bengaluru");
            jobs.setJobSkills("JavaSpringBoot");
            jobs.setCompany("Persistent");
            jobs.setJobDescription("Lead Developer");

            given(jobsService.saveJobs(jobs)).willReturn(jobs);
            mockMvc.perform( MockMvcRequestBuilders
                            .post("/api/v3/jobs/addJob")
                            .content(asJsonString(jobs))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());

        }

        @Test
        public void testListJobs() throws Exception {
               List<Jobs> jobsList =  new ArrayList<>();
               Jobs jobs = new Jobs();
               jobs.setJobId(1L);
               jobs.setJobTitle("Java");
               jobs.setJobLocation("Bengaluru");
               jobs.setJobSkills("JavaSpringBoot");
               jobs.setCompany("Persistent");
               jobs.setJobDescription("Lead Developer");

               jobsList.add(jobs);

               given(jobsService.retrieveAllJobs()).willReturn(jobsList);
               mockMvc.perform(MockMvcRequestBuilders.get("/api/v3/jobs/fetchAllJobs")
                               .accept(MediaType.APPLICATION_JSON))
                               .andDo(print())
                       .andExpect(status().isOk())
                       .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));


        }

        public static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    @Test
    public void testAddAllJobs() throws Exception {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobDescription("Lead Developer");
        jobsList.add(jobs);
        given(jobsService.saveAllJobs(jobsList)).willReturn(jobsList);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v3/jobs/saveAllJobs")
                        .content(asJsonString(jobsList))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}
