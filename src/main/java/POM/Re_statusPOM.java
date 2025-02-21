package POM;

import Generic.DriverManager;
import Generic.Excel_reader;
import Generic.Launch;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Re_statusPOM extends Launch {
    private AppiumDriver driver;
    private WebDriverWait wait;
    String re_status_check = Excel_reader.getLocation(from_location);

    public Re_statusPOM() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(accessibility = "Re-Status")
    private WebElement re_StatusButton;

    @AndroidFindBy(className= "android.widget.EditText")
    private WebElement locationField;

//    @AndroidFindBy(accessibility= "7004-Myntra Warehouse-(terminal)")
//    private WebElement selectLocation;


    @AndroidFindBy(accessibility= "Submit  ")
    private WebElement submit;

    public void tabRe_StatusButton() {
        re_StatusButton.click();
    }

    public void enterLocation(String location) {
        locationField.sendKeys(location);
    }

    public void tapLocation(){
        WebElement selectLocation =driver.findElement(AppiumBy.accessibilityId(re_status_check));
        selectLocation.click();}

    public void tapSubmit(){submit.click();}
}
