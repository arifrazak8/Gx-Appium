package Test;

import Generic.*;
import POM.*;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ArifTest extends Launch {

//    @Test(dataProvider = "testData" )
//    public void signin(String username, String password){
//
//        Sign_in_POM sign_in = new Sign_in_POM();
//        sign_in.enterUsername(username);
//        sign_in.enterPassword(password);
//        sign_in.tapViewPassword();
//        sign_in.tapSubmitButton();
//        sign_in.tapAllowButton2();
//        sign_in.tapAllowButton3();
//        sign_in.tapAllowButton1();
//    }

    @Test()
    public void TC1() throws InterruptedException {
        Clock_in_POM clock = new Clock_in_POM();
        Menu_POM menu = new Menu_POM();
        Dispatch_form_POM dispatchForm = new Dispatch_form_POM();
        Time_card_POM time =new Time_card_POM();
        //If clock_in required.
        try {
            try {
            clock.tabClock_In();
            clock.tabClock_In();
            wait(1000);
            clock.tapClickAsset();
            clock.tapEnterAsset();
            clock.tapSelectAsset();
            clock.tapContinueButton();
            clock.tapCheckBox();
            clock.tapContinueButton();
            clock.tapSign();
            clock.tapSubmit();
            System.out.println("Clock_in was required");
        } catch (Exception e) {
            System.out.println("Clock_in is not required");
            menu.tabMenuButton();
            menu.tapDispatchForm();
        }
        // For Re-status
            wait(1000);
            String re_status_check = Excel_reader.getLocation(from_location);
            WebElement a = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+re_status_check+"\").index(8)"));
            System.out.println("Re-status is not required");
        } catch (Exception e) {
            System.out.println("Re-status is required");
            Re_statusPOM reStatus = new Re_statusPOM();
            reStatus.tabRe_StatusButton();
            reStatus.enterLocation(from_location);
            reStatus.tapLocation();
            reStatus.tapSubmit();
        }


        dispatchForm.tapDispatchTo();
        dispatchForm.enterLocation();
        dispatchForm.tapSelectLocation();
        wait(1000);
//        Swipe.swipeAction(new Point(461, 2022), new Point(461, 622)); //for emulator
        Swipe.swipeAction(new Point(271, 1318), new Point(286, 333)); //for real device
        dispatchForm.enterTrailer1("1");
        dispatchForm.enterDolly1("2");
        dispatchForm.tapScreen();
        dispatchForm.enterTrailer2("3");
        dispatchForm.tapScreen();
//        dispatchForm.tapComboCheckbox();
        dispatchForm.enterMileage();
        dispatchForm.tapSubmitButton();
        dispatchForm.tapUploadImage();
        dispatchForm.tapUploadImageFile();
        dispatchForm.tapClickImage1();
        dispatchForm.tapPermission();
        dispatchForm.tapShutter();
        dispatchForm.tapDone();
        wait(1000);
//        Swipe.swipeAction(new Point(534, 2004), new Point(553, 387)); //for emulator
        Swipe.swipeAction(new Point(371, 1318), new Point(286, 333)); //for real devi?ce
        dispatchForm.tapClickImage2();
        dispatchForm.tapShutter();
        dispatchForm.tapDone();
        dispatchForm.tapSubmitButton();

        try {
            dispatchForm.tapNoButton();
            wait(1000);
        }catch (Exception e){
            System.out.println("Pass");
            wait(1000);
        }
        menu.tapBack();
        menu.tabMenuButton();
        menu.tapTimeCard();

        time.tapSelectDay("Monday");
        time.tapRequestMissedPunched();
        time.tapSelectEndTime();
        time.tapSelectTime();
        time.enterHours("10");
        time.enterMinutes("50");
        time.tapOK();
        time.enterMessage();
        time.tapSend();
    }
    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
//    @Test
//    public void TC2(){
//        Menu_POM menu = new Menu_POM();
//        menu.tabMenuButton();
//        menu.tapTimeCard();
//        Time_card_POM time =new Time_card_POM();
//        time.tapSelectDay("Monday");
//        time.tapRequestMissedPunched();
//        time.tapSelectEndTime();
//        time.tapSelectTime();
//        time.enterHours("10");
//        time.enterMinutes("50");
//        time.tapOK();
//        time.enterMessage();
//        time.tapSend();
//    }
}