package com.persistent.jobs.service.impl;

import com.persistent.jobs.entity.JobsAPI;
import com.persistent.jobs.repository.JobsAPIRepository;
import com.persistent.jobs.service.IJobsAPIService;
import com.persistent.jobs.utility.JobsAPIDownloadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

//create a class for JobsAPI service implementation
@Service
public class JobsAPIServiceImpl implements IJobsAPIService {
    @Autowired
    private JobsAPIRepository jobsAPIRepository;

    //Override all the methods based on IJobsAPIService interface
    @Override
    public JobsAPI saveJobsAPI(JobsAPI jobsAPI) {
        return jobsAPIRepository.save(jobsAPI);
    }

    @Override
    public List<JobsAPI> saveAllJobsAPI(List<JobsAPI> allJobsAPI) {
        return jobsAPIRepository.saveAll(allJobsAPI);
    }

    @Override
    public List<JobsAPI> fetchAllJobsAPI() {
        return jobsAPIRepository.findAll();
    }

    @Override
    public ByteArrayInputStream downloadDataToExecel() throws IOException {
        List<JobsAPI> jobsAPIDataFromDB = jobsAPIRepository.findAll();
        return JobsAPIDownloadHelper.downloadDataToExcel(jobsAPIDataFromDB);
    }
}
