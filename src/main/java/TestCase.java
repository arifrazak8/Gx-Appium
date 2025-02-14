import Generic.Excel_reader;
import Generic.Launch;
import Generic.Mileage;
import POM.Clock_in_POM;
import POM.Re_statusPOM;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Arrays;

public class TestCase extends Launch {

    @Test
    public void TC1() throws InterruptedException {
        Mileage m = new Mileage();
        String numberAsString = String.valueOf(Mileage.number);
        String loc= Excel_reader.getLocation(location);
        //If clock_in required.
        try {
            Clock_in_POM clock =new Clock_in_POM();
            clock.tabColck_In();
            clock.tabColck_In();
            Thread.sleep(2000);
            clock.tapClickAsset();
            clock.tapSelectAsset();
            clock.tapContinueButton();
            clock.tapCheckBox();
            clock.tapSign();
            clock.tapSubmit();
            System.out.println("Clock_in was required");
        } catch (Exception e) {
            System.out.println("Clock_in is not required");
            var Menu = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"));
            Menu.click();
            var Dispatch_Form = driver.findElement(AppiumBy.accessibilityId("Driver Dispatch Form"));
            Dispatch_Form.click();
        }
        try {
            var lo = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"7004-Myntra Warehouse-(terminal)\").index(8)"));
            System.out.println("Re-status is not required");
        } catch (Exception e){
            System.out.println("Re-status is required");
            Re_statusPOM reStatus=new Re_statusPOM();
            reStatus.tabRe_StatusButton();
            reStatus.enterLocation("7004");
            reStatus.tapLocation();
            reStatus.tapSubmit();
        }

        //If don't want to re-status.
//        var lo = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"7004-Myntra Warehouse-(terminal)\").index(8)"));
        //For first time user
//        var dispatch_form = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(15)"));
//        dispatch_form.click();
//        var clickk = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
//        clickk.sendKeys("7004");
//        var form_location = driver.findElement(AppiumBy.accessibilityId("7004-Myntra Warehouse-(terminal)"));
//        wait.until(ExpectedConditions.elementToBeClickable(form_location));
//        form_location.click();
        var dispatch_to = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(17)"));
        dispatch_to.click();
        var to_location = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
        to_location.sendKeys(location);
        var click = driver.findElement(AppiumBy.accessibilityId(loc));
        click.click();
        var Traile1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
        Traile1.click();
        Traile1.sendKeys("1");
        Thread.sleep(2000);
        var dolly1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
        wait.until(ExpectedConditions.elementToBeClickable(dolly1));
        dolly1.click();
        dolly1.sendKeys("2");

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

        var trailer2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
        wait.until(ExpectedConditions.elementToBeClickable(trailer2));
        trailer2.click();
        trailer2.sendKeys("3");
        var mileage = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
        mileage.click();
        mileage.sendKeys(numberAsString);
        Mileage.number+=1;
        m.saveNumberToFile(Mileage.number);
        var submit_btn1 = driver.findElement(AppiumBy.accessibilityId("Submit"));
        submit_btn1.click();
        Thread.sleep(2000);
        var image1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Proof of closed trailer 1 \n(Green Light or Physical Door Closed)\")"));
        image1.click();
        var shutter1 = driver.findElement(AppiumBy.accessibilityId("Shutter"));
        shutter1.click();
        var Done1 = driver.findElement(AppiumBy.accessibilityId("Done"));
        Done1.click();
        var image2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Proof of closed trailer 2 \n(Green Light or Physical Door Closed)\")"));
        image2.click();
        var shutter2 = driver.findElement(AppiumBy.accessibilityId("Shutter"));
        shutter2.click();
        var Done2 = driver.findElement(AppiumBy.accessibilityId("Done"));
        Done2.click();
        var submit_btn2 = driver.findElement(AppiumBy.accessibilityId("Submit"));
        submit_btn2.click();
        Thread.sleep(5000);

    }
    @Test
    public void TC2() throws InterruptedException {
        Mileage m = new Mileage();
        String numberAsString = String.valueOf(Mileage.number);
        var Traile1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
        Traile1.click();
        Traile1.sendKeys("2");

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start1 = new Point(483, 1728);
        var end1 = new Point (511, 954);
        var swipe1 = new Sequence(finger, 1);
        swipe1.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start1.getX(), start1.getY()));
        swipe1.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe1.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end1.getX(), end1.getY()));
        swipe1.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe1));
        Thread.sleep(2000);
        var mileage1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
        mileage1.click();
        mileage1.sendKeys(numberAsString);
        Mileage.number+=1;
        m.saveNumberToFile(Mileage.number);
        var submit_btn1 = driver.findElement(AppiumBy.accessibilityId("Submit"));
        submit_btn1.click();
        Thread.sleep(2000);
        var image1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Proof of closed trailer 1 \n(Green Light or Physical Door Closed)\")"));
        image1.click();
        var shutter1 = driver.findElement(AppiumBy.accessibilityId("Shutter"));
        shutter1.click();
        var Done1 = driver.findElement(AppiumBy.accessibilityId("Done"));
        Done1.click();
        var submit_btn2 = driver.findElement(AppiumBy.accessibilityId("Submit"));
        submit_btn2.click();
        Thread.sleep(5000);
    }
}
