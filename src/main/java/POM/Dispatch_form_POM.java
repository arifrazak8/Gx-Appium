package POM;

import Generic.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class Dispatch_form_POM extends Launch {

    private AppiumDriver driver;
    private WebDriverWait wait;
    private String loc =Excel_reader.getLocation(to_location);

    Mileage m = new Mileage();
    String numberAsString = String.valueOf(Mileage.number);

    public Dispatch_form_POM() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(15)")
    private WebElement dispatchFromTextField;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.view.View\").instance(17)")
    private WebElement dispatchToTextField;

    @AndroidFindBy(xpath= "//android.widget.EditText")
    private WebElement enterLocation;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement traile1;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc=\"Line Haul Dispatch Form\"]/android.view.View[1]/android.view.View/android.widget.EditText[2]")
    private WebElement dolly1;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement trailer2;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement mileage;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc=\"Line Haul Dispatch Form\"]/android.view.View[1]/android.view.View/android.widget.EditText[4]")
    private WebElement mileage1;

    @AndroidFindBy(accessibility= " Mark as Combo Trip")
    private WebElement comboCheckbox;

    @AndroidFindBy(accessibility=" Zero Package Trailer")
    private WebElement zeroCheckbox;

    @AndroidFindBy(accessibility= "Submit")
    private WebElement submitButton;

    @AndroidFindBy(uiAutomator= "new UiSelector().description(\"Proof Trip Buddy Closed \n(Screenshot Trip Buddy App)\")")
    private WebElement uploadImage;

    @AndroidFindBy(id= "com.google.android.providers.media.module:id/icon_thumbnail")
    private WebElement uploadImageFile;

    @AndroidFindBy(uiAutomator= "new UiSelector().description(\"Proof of closed trailer 1 \n(Green Light or Physical Door Closed)\")")
    private WebElement clickImage1;

    @AndroidFindBy(uiAutomator= "new UiSelector().description(\"Proof of closed trailer 2 \n(Green Light or Physical Door Closed)\")")
    private WebElement clickImage2;

    @AndroidFindBy(accessibility= "Shutter")
    private WebElement shutter ;

    @AndroidFindBy(accessibility= "Done")
    private WebElement done;

    @AndroidFindBy(id= "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement permission;

    @AndroidFindBy(accessibility= "Yes")
    private WebElement yesButton;

    @AndroidFindBy(accessibility= "No")
    private WebElement noButton;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.view.View\").instance(11)")
    private WebElement screenTap;

    public void tapDispatchFrom(){dispatchFromTextField.click();}

    public void tapDispatchTo(){dispatchToTextField.click();}

    public void enterLocation() {
        wait.until(ExpectedConditions.elementToBeClickable(enterLocation));
        enterLocation.sendKeys(to_location);
    }

    public void tapSelectLocation(){
        WebElement clickAction = driver.findElement(AppiumBy.accessibilityId(loc));
        clickAction.click();}

    public void enterTrailer1(String trailer1_no) {
        wait.until(ExpectedConditions.elementToBeClickable(traile1));
        traile1.click();
        traile1.sendKeys(trailer1_no);
    }

    public void enterDolly1(String dolly1_no) {
        wait.until(ExpectedConditions.elementToBeClickable(dolly1));
        dolly1.click();
        dolly1.sendKeys(dolly1_no);
    }

    public void enterTrailer2(String trailer2_no) {
        wait.until(ExpectedConditions.elementToBeClickable(trailer2));
        trailer2.click();
        trailer2.sendKeys(trailer2_no);
    }

    public void enterMileage() {
        wait.until(ExpectedConditions.elementToBeClickable(mileage));
        mileage.click();
        try {
//            wait.until(ExpectedConditions.visibilityOf(mileage));
            mileage.sendKeys(numberAsString);
        } catch (Exception e) {
//            wait.until(ExpectedConditions.visibilityOf(mileage1));
            mileage1.sendKeys(numberAsString);
        }
        Mileage.number+=1;
        m.saveNumberToFile(Mileage.number);
    }

    public void tapComboCheckbox(){comboCheckbox.click();}

    public void tapZeroCheckbox(){zeroCheckbox.click();}

    public void tapSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();}

    public void tapUploadImage(){uploadImage.click();}

    public void tapUploadImageFile(){uploadImageFile.click();}

    public void tapClickImage1(){
        wait.until(ExpectedConditions.elementToBeClickable(clickImage1));
        clickImage1.click();}

    public void tapClickImage2(){
        wait.until(ExpectedConditions.elementToBeClickable(clickImage2));
        clickImage2.click();}

    public void tapShutter(){shutter.click();}

    public void tapDone(){done.click();}

    public void tapPermission(){permission.click();}

    public void tapYesButton(){yesButton.click();}

    public void tapScreen(){screenTap.click();}

    public void tapNoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(noButton));
        noButton.click();}

}
