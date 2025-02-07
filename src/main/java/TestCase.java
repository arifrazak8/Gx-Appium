import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestCase extends Launch {

    @Test
    public void TC1() throws InterruptedException {
        //If clock_in required.
        try {
            new Clock_In().Clock_in();
        } catch (Exception e) {
            System.out.println("Clock_in is not required ");
            var Menu = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"));
            Menu.click();
            var Dispatch_Form = driver.findElement(AppiumBy.accessibilityId("Driver Dispatch Form"));
            Dispatch_Form.click();
        }
        var el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(15)"));
        el3.click();
        var el5 = driver.findElement(AppiumBy.className("android.widget.EditText"));
        el5.sendKeys("7004");
        var el6 = driver.findElement(AppiumBy.accessibilityId("7004-Myntra Warehouse-(terminal)"));
        wait.until(ExpectedConditions.elementToBeClickable(el6));
        el6.click();
        Thread.sleep(5000);
    }

}
