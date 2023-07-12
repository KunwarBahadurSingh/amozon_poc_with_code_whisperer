package com.persistent.jobs.controller;

import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.service.impl.JobsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v3/jobs")
public class JobsController{

    @Autowired
    private JobsServiceImpl jobsService;

    @PostMapping("/addJob")
    public ResponseEntity<Jobs> addJob(@RequestBody Jobs jobs){
        Jobs savedJobs = jobsService.saveJobs(jobs);
        return new ResponseEntity<Jobs>(savedJobs, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllJobs")
    public ResponseEntity<List<Jobs>> listJobs(){
        List<Jobs> allJobs = jobsService.retrieveAllJobs();
        return new ResponseEntity<List<Jobs>>(allJobs, HttpStatus.OK);
    }
    @PostMapping("/saveAllJobs")
    public ResponseEntity<List<Jobs>> addAllJobs(@RequestBody List<Jobs> allJobs){
        List<Jobs> saveAllJobs = jobsService.saveAllJobs(allJobs);
        return new ResponseEntity<List<Jobs>>(saveAllJobs, HttpStatus.CREATED);
    }

    @GetMapping("/bulkDownload")
    public ResponseEntity<Resource> downloadExcelFile() throws IOException {
        String fileName = "Jobs_Data_JobsWithoutCW.xlsx";
        ByteArrayInputStream byteArrayInputStream = jobsService.downloadExcel();
        InputStreamResource inputStreamResource = new InputStreamResource(byteArrayInputStream);
        ResponseEntity<Resource> body = ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + fileName).contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(inputStreamResource);
        return body;
    }
}
