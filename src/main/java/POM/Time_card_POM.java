package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import Generic.DriverManager;
import Generic.Launch;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Time_card_POM {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public Time_card_POM() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AndroidFindBy(accessibility= "Request Missed Punched")
    private WebElement request_Missed_Punched;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.view.View\").instance(11)")
    private WebElement selectEndTime;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.Button\").instance(0)")
    private WebElement selectTime;

    @AndroidFindBy(accessibility= "Cancel")
    private WebElement cancelButton;

    @AndroidFindBy(accessibility= "OK")
    private WebElement oKButton;

    @AndroidFindBy(xpath= "(//android.widget.EditText)[1]")
    private WebElement hours;

    @AndroidFindBy(xpath= "(//android.widget.EditText)[2]")
    private WebElement minutes;

    @AndroidFindBy(xpath= "//android.widget.EditText")
    private WebElement enterMessage;

    @AndroidFindBy(accessibility= "Send")
    private WebElement sendButton;

    public void tapSelectDay(String dayOfWeek) {
        String dynamicXPath = String.format("//android.view.View[contains(@content-desc, '%s')]", dayOfWeek);
        WebElement selectDay =  driver.findElement(AppiumBy.xpath(dynamicXPath));
        selectDay.click();
    }

    public void tapRequestMissedPunched(){request_Missed_Punched.click();}
    public void tapSelectEndTime(){selectEndTime.click();}
    public void tapSelectTime(){selectTime.click();}
    public void tapCancel(){cancelButton.click();}
    public void tapOK(){oKButton.click();}
    public void tapSend(){sendButton.click();}

    public void enterMessage() {
        enterMessage.click();;
        enterMessage.sendKeys("Test Appium");
    }
    public void enterHours(String hour) {
        wait.until(ExpectedConditions.elementToBeClickable(hours));
        hours.click();
        hours.clear();
        hours.sendKeys(hour);
    }
    public void enterMinutes(String minute) {
        wait.until(ExpectedConditions.elementToBeClickable(minutes));
        minutes.click();
        minutes.clear();
        minutes.sendKeys(minute);
    }


}
