package com.learn.TestData;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelTestData {
    @Test
    @DataProvider(name="LoginData")
    public String[][] DataSuplier() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/PoundLandTestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("TestData");
        int noOfRows = xssfSheet.getPhysicalNumberOfRows();
        int noOfColumns = xssfSheet.getRow(0).getLastCellNum();
        String[][] data = new String[noOfRows - 1][noOfColumns];
        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(xssfSheet.getRow(i + 1).getCell(j));
            }
        }
        xssfWorkbook.close();
        fileInputStream.close();

        return data;
    }




}
