package Generic;

import POM.Sign_in_POM;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Launch implements Constant
{

    public static AndroidDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        DriverManager.initializeDriver();

        //For SignIn
        Sign_in_POM sign_in = new Sign_in_POM();
        sign_in.enterUsername(username);
        sign_in.enterPassword(password);
        sign_in.tapViewPassword();
        sign_in.tapSubmitButton();
        sign_in.tapAllowButton1();
        sign_in.tapAllowButton2();
        sign_in.tapAllowButton3();
    }

    @BeforeTest
    public  void mil(){
        Mileage m= new Mileage();
        Mileage.number = m.readNumberFromFile();
    }

    @AfterClass
    public void teardown() {
        DriverManager.quitDriver();
    }
}
