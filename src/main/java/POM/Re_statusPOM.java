package POM;

import Generic.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Re_statusPOM {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public Re_statusPOM() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AndroidFindBy(accessibility = "Re-Status")
    private WebElement re_StatusButton;

    @AndroidFindBy(className= "android.widget.EditText")
    private WebElement locationField;

    @AndroidFindBy(accessibility= "7004-Myntra Warehouse-(terminal)")
    private WebElement selectLocation;


    @AndroidFindBy(accessibility= "Submit  ")
    private WebElement submit;

    public void tabRe_StatusButton() {
        re_StatusButton.click();
    }

    public void enterLocation(String location) {
        locationField.sendKeys(location);
    }

    public void tapLocation(){selectLocation.click();}

    public void tapSubmit(){submit.click();}
}
