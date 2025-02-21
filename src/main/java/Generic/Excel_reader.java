package Generic;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel_reader extends Launch {

    private static final String FILE_PATH ="D:\\Arif\\GX Appium\\src\\main\\resources\\Locations.xlsx";
    private static Workbook workbook;
    private static Sheet sheet;

    public static String getLocation(String location) {

        String locations="";

        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            int locColumn = 0;

            // Determine column index for selected locations
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(location)) {
                    locColumn = cell.getColumnIndex();
                    break;
                }
            }

            Row row =sheet.getRow(1);
            locations =row.getCell(locColumn).getStringCellValue();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return locations;
    }

    public static Object[][] getTestData() throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(1);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row

            for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header row
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString(); // Store each cell value
                }
            }
            return data;

        }catch (IOException e) {
                e.printStackTrace();
                return new Object[0][0]; // Return empty array if error occurs
            }
    }
}
