package POM;

import Generic.DriverManager;
import Generic.Launch;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Clock_in_POM extends Launch {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private WebElement selectAsset;

    public Clock_in_POM() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(accessibility = "Clock In")
    private WebElement clock_InButton;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.view.View\").instance(15)")
    private WebElement clickAsset;

    @AndroidFindBy(className= "android.widget.EditText")
    private WebElement enterAsset;

    @AndroidFindBy(accessibility= "Continue")
    private WebElement continueButton;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.CheckBox\").instance(0)")
    private WebElement checkBox;

    @AndroidFindBy(accessibility= "Please Sign *")
    private WebElement sign;

    @AndroidFindBy(accessibility= "Submit")
    private WebElement submit;

    public void tabClock_In() {
        wait.until(ExpectedConditions.elementToBeClickable(clock_InButton));
        clock_InButton.click();
    }

    public void tapClickAsset() {
        wait.until(ExpectedConditions.elementToBeClickable(clickAsset));
        clickAsset.click();
    }

    public void tapEnterAsset() {
        wait.until(ExpectedConditions.elementToBeClickable(enterAsset));
        enterAsset.sendKeys(asset_no);
    }

    public void tapSelectAsset() throws InterruptedException {
        Thread.sleep(2000);
        this.selectAsset = driver.findElement(AppiumBy.accessibilityId(asset_no));
        wait.until(ExpectedConditions.elementToBeClickable(selectAsset));
        selectAsset.click();}

    public void tapContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public void tapCheckBox(){
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();}

    public void tapSign(){
        wait.until(ExpectedConditions.elementToBeClickable(sign));
        sign.click();}

    public void tapSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();}
}
