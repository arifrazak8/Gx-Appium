import Generic.Launch;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Clock_In extends Launch {
    public void Clock_in() throws InterruptedException {

        var Clock_In = driver.findElement(AppiumBy.accessibilityId("Clock In"));
        wait.until(ExpectedConditions.elementToBeClickable(Clock_In));
        Clock_In.click();
        var Clock_In1 = driver.findElement(AppiumBy.accessibilityId("Clock In"));
        Clock_In1.click();
        Thread.sleep(2000);
        var el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(15)"));
        wait.until(ExpectedConditions.elementToBeClickable(el3));
        el3.click();
        var el2 = driver.findElement(AppiumBy.accessibilityId("123452"));
        wait.until(ExpectedConditions.elementToBeClickable(el2));
        el2.click();
//        var el4 = driver.findElement(AppiumBy.className("android.widget.EditText"));
//        wait.until(ExpectedConditions.elementToBeClickable(el4));
//        el4.click();
        var Continue = driver.findElement(AppiumBy.accessibilityId("Continue"));
        Continue.click();
        var el6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.CheckBox\").instance(0)"));
        wait.until(ExpectedConditions.elementToBeClickable(el6));
        el6.click();
        Continue.click();
        var el8 = driver.findElement(AppiumBy.accessibilityId("Please Sign *"));
        wait.until(ExpectedConditions.elementToBeClickable(el8));
        el8.click();
        var submit =driver.findElement(AppiumBy.accessibilityId("Submit"));
        submit.click();
    }
}
