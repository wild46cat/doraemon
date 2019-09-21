package com.example.demo.excel.poireaderutils;

import java.io.InputStream;
import java.util.List;

public interface ExcelReader {
    public List<String[]> getSheet(int page);

    public int getSheetNum();

    public void readExcelContent(InputStream in, int colNum);

    public List<String[]> readSheetContent(InputStream in, int colNum, int sheetNum);
}
