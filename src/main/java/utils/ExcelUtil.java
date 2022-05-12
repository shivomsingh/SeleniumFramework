package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    private static Workbook book;
    private static Sheet sheet;

    public static Object[][] getData() {
        Object[][] sheetData = null;

        try {
            FileInputStream io = new FileInputStream(ConstantUtil.EXCEL_SHEET_PATH);
            book = WorkbookFactory.create(io);
            sheet = book.getSheet(ConstantUtil.EXCEL_SHEET_NAME);

             sheetData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for(int i = 0;i<sheet.getLastRowNum();i++){
                for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                    sheetData[i][j] = sheet.getRow(i+1).getCell(j).toString();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return sheetData;
    }
}
