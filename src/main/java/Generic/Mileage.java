package Generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Mileage {
    public String FILE_PATH = "counter.properties";
    public static int number;

    public int readNumberFromFile() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            properties.load(fis);
            return Integer.parseInt(properties.getProperty("number", "55")); // Default value 55
        } catch (IOException e) {
            e.printStackTrace();
            return 55; // Default value if file doesn't exist
        }
    }

    // Method to save the updated number back to the file
     public void saveNumberToFile(int number) {
        Properties properties = new Properties();
        properties.setProperty("number", String.valueOf(number));
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            properties.store(fos, "Updated Number");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

