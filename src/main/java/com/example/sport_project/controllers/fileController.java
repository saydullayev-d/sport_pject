package com.example.sport_project.controllers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fileController {

    public void insertData(File selectedFile){
        if (selectedFile != null) {
            try {
                XSSFWorkbook workbook = new XSSFWorkbook(selectedFile);
                XSSFSheet sheet = workbook.getSheetAt(0);
                for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    XSSFRow row = sheet.getRow(rowNum);
                    if (row != null) {
                        System.out.println("Строка: " + rowNum);
                        for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++) {
                            XSSFCell cell = row.getCell(cellNum);
                            if (cell != null) {
                                switch (cell.getCellType()){
                                    case STRING:
                                        String StringcellValue = cell.getStringCellValue();
                                        System.out.println("Значение ячейки: " + StringcellValue);
                                        break;
                                    case NUMERIC:
                                        if (DateUtil.isCellDateFormatted(cell)) {
                                            Date dateValue = cell.getDateCellValue();
                                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Формат даты
                                            String formattedDate = dateFormat.format(dateValue);
                                            System.out.println("Значение ячейки: " + formattedDate);
                                        }
                                        else{
                                            double NumericellValue = cell.getNumericCellValue();
                                            System.out.println("Значение ячейки: " + NumericellValue);
                                        }
                                        break;
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);

            } catch (InvalidFormatException e) {
                throw new RuntimeException(e);
            }

        }
    }
}