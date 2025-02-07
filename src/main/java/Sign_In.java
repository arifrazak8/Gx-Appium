import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sign_In extends Launch {
    public void Signin() throws InterruptedException {
        var uname = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
        wait.until(ExpectedConditions.elementToBeClickable(uname));
        uname.click();
        uname.sendKeys(username);
        var pass = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
        pass.click();
        pass.sendKeys(password);
        var view = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)"));
        view.click();
        var submit_btn = driver.findElement(AppiumBy.accessibilityId("Submit"));
        submit_btn.click();
        var allow = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
        allow.click();
        var allow1 = driver.findElement(AppiumBy.accessibilityId("Accept"));
        allow1.click();
        var allow2 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        allow2.click();
    }
}
