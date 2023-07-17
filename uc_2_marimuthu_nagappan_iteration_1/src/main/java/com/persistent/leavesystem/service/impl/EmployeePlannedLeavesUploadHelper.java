package com.persistent.leavesystem.service.impl;
//create Helper class for uploading excel file logic in this class
import com.persistent.leavesystem.entity.EmployeePlannedLeaves;
import com.persistent.leavesystem.repository.EmployeePlannedLeavesRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
@Service
public class EmployeePlannedLeavesUploadHelper {
    @Autowired
    EmployeePlannedLeavesRepository employeePlannedLeavesRepository;

    // create a method to upload excel file into EmployeePlannedLeaves table
    public void uploadExcelFileForEmployeePlannedLeaves(InputStream is) throws IOException {
        try (XSSFWorkbook workBook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workBook.getSheet("Sheet1");
            int lastNum = 0;
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    lastNum = row.getLastCellNum();
                }
                //process excel file to insert into table if record exists in the file
                if (row.getRowNum() != 0) {
                    EmployeePlannedLeaves employeePlannedLeaves=new EmployeePlannedLeaves();
                    for (int cn = 0; cn < lastNum; cn++) {
                        Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        //set the values from excel as cell and insert into EmployeePlannedLeaves table
                        switch(cn){
                            case 0:
                                employeePlannedLeaves.setEmployeeId((int) cell.getNumericCellValue());
                                break;
                            case 1:
                                employeePlannedLeaves.setEmployeeFirstName(cell.getStringCellValue());
                                break;
                            case 2:
                                employeePlannedLeaves.setEmployeeMiddleName(cell.getStringCellValue());
                                break;
                            case 3:
                                employeePlannedLeaves.setEmployeeLastName(cell.getStringCellValue());
                                break;
                            case 4:
                                employeePlannedLeaves.setEmployeeEmailId(cell.getStringCellValue());
                                break;
                            case 5:
                                employeePlannedLeaves.setEmployeePhone(Long.valueOf((long) cell.getNumericCellValue()));
                                break;
                            case 6:
                                employeePlannedLeaves.setEmployeeDesignation(cell.getStringCellValue());
                                break;
                            case 7:
                                employeePlannedLeaves.setEmployeeLeaveStartDate(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                                break;
                            case 8:
                                employeePlannedLeaves.setEmployeeLeaveEndDate(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                                break;
                            case 9:
                                employeePlannedLeaves.setEmployeeLocation(cell.getStringCellValue());
                                break;
                            case 10:
                                employeePlannedLeaves.setEmployeeLeaveCount((int) cell.getNumericCellValue());
                        }
                    }
                    employeePlannedLeavesRepository.save(employeePlannedLeaves);
                }
            }
        }
    }
}
