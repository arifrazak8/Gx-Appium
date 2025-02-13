
import Generic.Launch;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Exception_handle extends Launch {



    public boolean clickIfElementExists(AppiumBy by) {
        try {
            WebElement element = driver.findElement(by);
            element.click();
            System.out.println("Clicked on: " + by);
            return true; // Element was found and clicked
        } catch (NoSuchElementException e) {
            System.out.println("Element not found, skipping: " + by);
            return false; // Element was not found
        }
    }
}
