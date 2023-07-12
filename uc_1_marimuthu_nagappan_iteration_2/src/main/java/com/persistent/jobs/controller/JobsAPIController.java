package com.persistent.jobs.controller;

import com.persistent.jobs.entity.JobsAPI;
import com.persistent.jobs.service.impl.JobsAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.print.attribute.standard.Media;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

//create a Controller class for JobsAPI
@RestController
@RequestMapping("/api/v4/jobsAPI")
public class JobsAPIController {
    @Autowired
    private JobsAPIServiceImpl jobsAPIServiceImpl;
    //create a method for saveJobs
    @PostMapping("/saveJobs")
    public ResponseEntity<JobsAPI> saveJobs(@RequestBody JobsAPI jobsAPI){
        JobsAPI saveJobs = jobsAPIServiceImpl.saveJobsAPI(jobsAPI);
        return new ResponseEntity<JobsAPI>(saveJobs,HttpStatus.CREATED);
    }

    //create a method for saveAllJobs
    @PostMapping("/saveAllJobs")
    public ResponseEntity<List<JobsAPI>> saveAllJobs(@RequestBody List<JobsAPI> allJobsAPI){
        List<JobsAPI> saveAllJobsAPI = jobsAPIServiceImpl.saveAllJobsAPI(allJobsAPI);
        return new ResponseEntity<List<JobsAPI>>(saveAllJobsAPI, HttpStatus.CREATED);
    }

    //create a method for fetchAllJobs
    @GetMapping("/fetchAllJobs")
    public ResponseEntity<List<JobsAPI>> fetchAllJobs(){
        List<JobsAPI> fetchAllJobsData = jobsAPIServiceImpl.fetchAllJobsAPI();
        return new ResponseEntity<List<JobsAPI>>(fetchAllJobsData, HttpStatus.OK);
    }

    //create a method to download
    @GetMapping("/bulkDataDownload")
    public ResponseEntity<Resource> downloadExcel() throws IOException {
        String fileName ="JobsAPI_data.xlsx";
        ByteArrayInputStream byteArrayInputStream = jobsAPIServiceImpl.downloadDataToExecel();
        InputStreamResource inputStreamResource = new InputStreamResource(byteArrayInputStream);
        ResponseEntity<Resource> responseAsExcel = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" +fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(inputStreamResource);
        return responseAsExcel;
    }
}
