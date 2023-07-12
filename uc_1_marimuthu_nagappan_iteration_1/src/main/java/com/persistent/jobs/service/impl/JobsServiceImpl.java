package com.persistent.jobs.service.impl;

import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.repository.JobsRepository;
import com.persistent.jobs.service.IJobsService;
import com.persistent.jobs.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class JobsServiceImpl implements IJobsService {

    @Autowired
    private JobsRepository jobsRepository;

    @Override
    public Jobs saveJobs(Jobs Jobs) {
        return jobsRepository.save(Jobs);
    }

    @Override
    public List<Jobs> retrieveAllJobs() {
        return jobsRepository.findAll();
    }

    @Override
    public List<Jobs> saveAllJobs(List<Jobs> allJobs) {
        return jobsRepository.saveAll(allJobs);
    }

    @Override
    public ByteArrayInputStream downloadExcel() throws IOException {
        List<Jobs> storedJobsToDownload = jobsRepository.findAll();
        return Helper.dataToExcel(storedJobsToDownload);
    }
}
