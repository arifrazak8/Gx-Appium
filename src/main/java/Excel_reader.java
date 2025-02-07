import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Excel_reader extends Launch {
    public static Map<String, String> getTranslations(String filePath, String language) {
        Map<String, String> translations = new LinkedHashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int langColumn = 1; // Default to English

            // Determine column index for selected language
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(language)) {
                    langColumn = cell.getColumnIndex();
                    break;
                }
            }

            // Read element IDs and corresponding translations
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
//                    String elementID = row.getCell(0).getStringCellValue();
                    String elementID = "\""+row.getCell(langColumn).getStringCellValue()+"\"";
                    String translatedText = row.getCell(langColumn).getStringCellValue();
                    translations.put(elementID, translatedText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return translations;
    }
}
