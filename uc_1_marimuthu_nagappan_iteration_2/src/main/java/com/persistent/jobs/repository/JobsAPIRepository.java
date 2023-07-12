package com.persistent.jobs.repository;

import com.persistent.jobs.entity.JobsAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//create a interface for JobsAPI
@Repository
public interface JobsAPIRepository extends JpaRepository<JobsAPI, Long> {
    public JobsAPI save(JobsAPI jobsAPI);
    public List<JobsAPI> saveAll(List<JobsAPI> listJobsAPI);
}
