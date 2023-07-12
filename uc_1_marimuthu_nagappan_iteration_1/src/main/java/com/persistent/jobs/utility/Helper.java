package com.persistent.jobs.utility;

import com.persistent.jobs.entity.Jobs;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Helper{

    private static String[] HEADERS = {
        "job_id",
        "company",
            "job_location",
            "job_skills",
            "job_title",
            "job_description",
            "posted_date"
    };

    private static String SHEET_NAME= "Jobs_Data_WithoutCW";

   public static ByteArrayInputStream dataToExcel(List<Jobs> fetchStoredJobs) throws IOException {
       Workbook workbook = new XSSFWorkbook();
       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       Sheet sheet= workbook.createSheet(SHEET_NAME);
       Row row = sheet.createRow(0);
       try {
           for (int i = 0; i < HEADERS.length; i++) {
               Cell cell = row.createCell(i);
               cell.setCellValue(HEADERS[i]);
           }
           int rowNum = 1;
           for (Jobs jobs : fetchStoredJobs) {
               Row rowDBTbl = sheet.createRow(rowNum++);
               rowDBTbl.createCell(0).setCellValue(jobs.getJobId());
               rowDBTbl.createCell(1).setCellValue(jobs.getCompany());
               rowDBTbl.createCell(2).setCellValue(jobs.getJobLocation());
               rowDBTbl.createCell(3).setCellValue(jobs.getJobSkills());
               rowDBTbl.createCell(4).setCellValue(jobs.getJobTitle());
               rowDBTbl.createCell(5).setCellValue(jobs.getJobDescription());
               rowDBTbl.createCell(6).setCellValue(jobs.getPostedDate());
           }
           workbook.write(byteArrayOutputStream);
           return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("Failed to export data into excel sheet");
           return null;
       } finally{
           workbook.close();
           byteArrayOutputStream.close();
       }
   }
}