package com.persistent.jobs.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.persistent.jobs.entity.JobsAPI;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//create a class for downloading JobsAPI as excel file
public class JobsAPIDownloadHelper {

    //create headers
    private static String[] headers ={
            "Jobs_Id",
            "Company",
            "Jobs_Description",
            "Jobs_Location",
            "Jobs_Posted_Date",
            "Jobs_Skills",
            "Jobs_Title"
    };
    //create excel file name;
    private static String FILE_NAME ="JobsAPI_Data";

    //create a method to download as excel file for Jobs API
    public static ByteArrayInputStream downloadDataToExcel(List<JobsAPI> fetchJobsAPIDB) throws IOException {
        //create a Workbook
        Workbook workbook = new XSSFWorkbook();
        //create ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //create Sheet
        Sheet sheet = workbook.createSheet(FILE_NAME);
        //create Row
        Row row = sheet.createRow(0);
        try {
            for (int i = 0; i < headers.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(headers[i]);
            }
            int rowNum = 1;
            for (JobsAPI jobsAPI : fetchJobsAPIDB) {
                Row rowDBTbl = sheet.createRow(rowNum++);
                rowDBTbl.createCell(0).setCellValue(jobsAPI.getJobsId());
                rowDBTbl.createCell(1).setCellValue(jobsAPI.getCompany());
                rowDBTbl.createCell(2).setCellValue(jobsAPI.getJobsDescription());
                rowDBTbl.createCell(3).setCellValue(jobsAPI.getJobsLocation());
                rowDBTbl.createCell(4).setCellValue(jobsAPI.getJobsPostedDate());
                rowDBTbl.createCell(5).setCellValue(jobsAPI.getJobsSkills());
                rowDBTbl.createCell(6).setCellValue(jobsAPI.getJobsTitle());
            }
            workbook.write(byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to export data into excel sheet from DB Table of JobsAPI data");
            return null;
        } finally{
            workbook.close();
            byteArrayOutputStream.close();
        }

    }
}
