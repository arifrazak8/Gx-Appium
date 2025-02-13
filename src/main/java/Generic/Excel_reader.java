package Generic;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel_reader extends Launch {
    public static String getLocation(String location) {
        String filePath ="C:/Users/Wadmin/Downloads/Location.xlsx";
        String locations="";
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int locColumn = 0;

            // Determine column index for selected locations
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(location)) {
                    locColumn = cell.getColumnIndex();
                    break;
                }
            }

            // Read search and corresponding locations
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//                if (row != null) {
////                    String search = row.getCell(0).getStringCellValue();
//                    String locationss = "\""+row.getCell(locColumn).getStringCellValue()+"\"";
//                    String translatedText = row.getCell(locColumn).getStringCellValue();
//                    locations.put(locationss, translatedText);
//                }
//            }
            Row row =sheet.getRow(1);
            locations =row.getCell(locColumn).getStringCellValue();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return locations;
    }
}
