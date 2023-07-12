package com.persistent.jobs.service;

import com.persistent.jobs.entity.JobsAPI;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

//create a interface for JobsAPI service
public interface IJobsAPIService {
    //create a method for save JobsAPI
    public JobsAPI saveJobsAPI(JobsAPI jobsAPI);

    //create a method for save all the JobsAPI
    public List<JobsAPI> saveAllJobsAPI(List<JobsAPI> allJobsAPI);

    //create a method for fetch all the JobsAPI
    public List<JobsAPI> fetchAllJobsAPI();

    //create a method for download dataToExcel for stored JobsAPI from DB
    public ByteArrayInputStream downloadDataToExecel() throws IOException;
}
