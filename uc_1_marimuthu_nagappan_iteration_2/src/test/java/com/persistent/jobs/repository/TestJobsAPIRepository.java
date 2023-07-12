package com.persistent.jobs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//create a interface for JobsAPIRepository
@DataJpaTest
public class TestJobsAPIRepository {
    @Autowired
    private JobsAPIRepository jobsAPIRepository;
}
