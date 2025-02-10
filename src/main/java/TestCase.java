import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

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
        var dispatch_form = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(15)"));
        dispatch_form.click();
        var clickk = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
        clickk.sendKeys("7004");
        var form_location = driver.findElement(AppiumBy.accessibilityId("7004-Myntra Warehouse-(terminal)"));
        wait.until(ExpectedConditions.elementToBeClickable(form_location));
        form_location.click();
        var el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(17)"));
        el3.click();
        var el4 = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
        el4.sendKeys("101");
        var el5 = driver.findElement(AppiumBy.accessibilityId("101-Roadster-(spot)"));
        el5.click();
        var el6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
        el6.click();
        el6.sendKeys("1");
        Thread.sleep(2000);
        var el7 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
        wait.until(ExpectedConditions.elementToBeClickable(el7));
        el7.click();
        el7.sendKeys("2");

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(491, 1752);
        var end = new Point (491, 624);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        var el8 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
        wait.until(ExpectedConditions.elementToBeClickable(el8));
        el8.click();
        el8.sendKeys("3");
        var el9 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
        el9.click();
        el9.sendKeys("225683");
        var el10 = driver.findElement(AppiumBy.accessibilityId("Submit"));
        el10.click();
    }

}
