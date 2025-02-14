package POM;

import Generic.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Clock_in_POM {
    private AppiumDriver driver;

    public Clock_in_POM() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "Clock In")
    private WebElement clock_InButton;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.view.View\").instance(15)")
    private WebElement clickAsset;

    @AndroidFindBy(accessibility= "123452")
    private WebElement selectAsset;

    @AndroidFindBy(accessibility= "Continue")
    private WebElement continueButton;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.CheckBox\").instance(0)")
    private WebElement checkBox;

    @AndroidFindBy(accessibility= "Please Sign *")
    private WebElement sign;

    @AndroidFindBy(accessibility= "Submit")
    private WebElement submit;

    public void tabColck_In() {
        clock_InButton.click();
    }

    public void tapClickAsset() {
        clickAsset.click();

    }

    public void tapSelectAsset(){selectAsset.click();}

    public void tapContinueButton() {
        continueButton.click();
    }

    public void tapCheckBox(){checkBox.click();}

    public void tapSign(){sign.click();}

    public void tapSubmit(){submit.click();}
}
