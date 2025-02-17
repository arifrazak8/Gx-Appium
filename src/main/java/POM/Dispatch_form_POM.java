package POM;

import Generic.Constant;
import Generic.DriverManager;
import Generic.Excel_reader;
import Generic.Mileage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class Dispatch_form_POM implements Constant {

    private AppiumDriver driver;
    private WebDriverWait wait;
    private WebElement clickAction;
    private String loc =Excel_reader.getLocation(location);

    Mileage m = new Mileage();
    String numberAsString = String.valueOf(Mileage.number);

    public Dispatch_form_POM() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println(loc);
        this.clickAction = driver.findElement(AppiumBy.accessibilityId(loc));
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(15)")
    private WebElement dispatchFromTextField;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.view.View\").instance(17)")
    private WebElement dispatchToTextField;

    @AndroidFindBy(xpath= "//android.widget.EditText")
    private WebElement enterLocation;

//    @AndroidFindBy(accessibility= loc)
//    private WebElement clickAction;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement traile1;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement dolly1;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement trailer2;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement mileage;

    @AndroidFindBy(accessibility= " Mark as Combo Trip")
    private WebElement comboCheckbox;

    @AndroidFindBy(accessibility="")
    private WebElement zeroCheckbox;

    @AndroidFindBy(accessibility= "Submit")
    private WebElement submitButton;

    @AndroidFindBy(uiAutomator= "new UiSelector().description(\"Proof of closed trailer 1 \n(Green Light or Physical Door Closed)\")")
    private WebElement clickImage1;

    @AndroidFindBy(uiAutomator= "new UiSelector().description(\"Proof of closed trailer 2 \n(Green Light or Physical Door Closed)\")")
    private WebElement clickImage2;

    @AndroidFindBy(accessibility= "Shutter")
    private WebElement shutter ;

    @AndroidFindBy(accessibility= "Done")
    private WebElement done;

    public void tapDispatchFrom(){dispatchFromTextField.click();}

    public void tapDispatchTo(){dispatchToTextField.click();}

    public void enterLocation() {
        wait.until(ExpectedConditions.elementToBeClickable(enterLocation));
        enterLocation.click();
        enterLocation.sendKeys(location);
    }

    public void tapSelectLocation(){clickAction.click();}

    public void enterTraile1(String traile1_no) {
        wait.until(ExpectedConditions.elementToBeClickable(traile1));
        traile1.click();
        traile1.sendKeys(traile1_no);
    }

    public void enterDolly1(String dolly1_no) {
        wait.until(ExpectedConditions.elementToBeClickable(dolly1));
        dolly1.click();
        dolly1.sendKeys(dolly1_no);
    }

    public void swipeAction(){
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
    }

    public void enterTrailer2(String trailer2_no) {
        wait.until(ExpectedConditions.elementToBeClickable(trailer2));
        trailer2.click();
        trailer2.sendKeys(trailer2_no);
    }

    public void enterMileage() {
        wait.until(ExpectedConditions.elementToBeClickable(mileage));
        mileage.click();
        mileage.sendKeys(numberAsString);
        Mileage.number+=1;
        m.saveNumberToFile(Mileage.number);
    }

    public void tapComboCheckbox(){comboCheckbox.click();}

    public void tapZeroCheckbox(){zeroCheckbox.click();}

    public void tapSubmitButton(){submitButton.click();}

    public void tapClickImage1(){clickImage1.click();}

    public void tapClickImage2(){clickImage2.click();}

    public void tapShutter(){shutter.click();}

    public void tapDone(){done.click();}

}
