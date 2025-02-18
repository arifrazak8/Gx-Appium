package Test;

import Generic.Excel_reader;
import Generic.Launch;
import Generic.Mileage;
import POM.Clock_in_POM;
import POM.Dispatch_form_POM;
import POM.Menu_POM;
import POM.Re_statusPOM;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ArifTest extends Launch {

    @Test
    public void TC1() throws InterruptedException {

        //If clock_in required.
        try {
            Clock_in_POM clock = new Clock_in_POM();
            clock.tabColck_In();
            clock.tabColck_In();
            Thread.sleep(2000);
            clock.tapClickAsset();
            clock.tapSelectAsset();
            clock.tapContinueButton();
            clock.tapCheckBox();
            clock.tapContinueButton();
            clock.tapSign();
            clock.tapSubmit();
            System.out.println("Clock_in was required");
        } catch (Exception e) {
            System.out.println("Clock_in is not required");
            Menu_POM menu = new Menu_POM();
            menu.tabMenuButton();
            menu.tapDispatchForm();
        }
        // For Re-status
//        try {
//            Thread.sleep(2000);
//            WebElement a = driver.findElement(AppiumBy.androidUIAutomator(re_status_check));
//            System.out.println("Re-status is not required");
//        } catch (Exception e) {
//            System.out.println("Re-status is required");
//            Re_statusPOM reStatus = new Re_statusPOM();
//            reStatus.tabRe_StatusButton();
//            reStatus.enterLocation("7004");
//            reStatus.tapLocation();
//            reStatus.tapSubmit();
//        }

        Dispatch_form_POM dispatchForm = new Dispatch_form_POM();
        dispatchForm.tapDispatchTo();
        dispatchForm.enterLocation();
        dispatchForm.tapSelectLocation();
        dispatchForm.enterTraile1("1");
        dispatchForm.enterDolly1("2");
        dispatchForm.swipeAction();
        dispatchForm.enterTrailer2("3");
        dispatchForm.enterMileage();
        dispatchForm.tapSubmitButton();
        dispatchForm.tapClickImage1();
        dispatchForm.tapShutter();
        dispatchForm.tapDone();
        dispatchForm.tapClickImage2();
        dispatchForm.tapShutter();
        dispatchForm.tapDone();
        dispatchForm.tapSubmitButton();
        Thread.sleep(5000);
    }
}