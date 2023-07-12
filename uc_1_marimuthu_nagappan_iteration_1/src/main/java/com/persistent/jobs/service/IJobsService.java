package com.persistent.jobs.service;

import com.persistent.jobs.entity.Jobs;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface IJobsService {

    public Jobs saveJobs(Jobs jobs);

    public List<Jobs> retrieveAllJobs();

    public List<Jobs>  saveAllJobs(List<Jobs> allJobs);

    public ByteArrayInputStream downloadExcel() throws IOException;
}
