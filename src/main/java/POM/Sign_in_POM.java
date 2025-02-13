package POM;

import Generic.Launch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;

public class Sign_in_POM extends Launch {


    public Sign_in_POM(WebDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement usernameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator= "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private WebElement viewPassword;

    @AndroidFindBy(accessibility= "Submit")
    private WebElement submitButton;

    @AndroidFindBy(id= "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowButton1;

    @AndroidFindBy(accessibility= "Accept")
    private WebElement allowButton2;

    @AndroidFindBy(id= "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement allowButton3;

    public void enterUsername(String username) {
        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void tapViewPassword(){viewPassword.click();}

    public void tapSubmitButton() {
        submitButton.click();
    }

    public void tapAllowButton1(){allowButton1.click();}

    public void tapAllowButton2(){allowButton2.click();}

    public void tapAllowButton3(){allowButton3.click();}

}
