package Generic;

import POM.Sign_in_POM;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import javax.swing.*;
import java.io.IOException;

public class Launch extends Testdata
{
    public AppiumDriver driver;

    @BeforeClass()
    public void setUp() {
        // Show a pop-up dialog to enter input before the test starts
//        asset_no = JOptionPane.showInputDialog("Enter the Asset_no:");  //if clock_in required
        from_location= JOptionPane.showInputDialog("Enter the Dispatch_From:");
        to_location = JOptionPane.showInputDialog("Enter the Dispatch_To:");
        DriverManager.initializeDriver();
        this.driver = DriverManager.getDriver();

        //For SignIn
        Sign_in_POM sign_in = new Sign_in_POM();
        sign_in.enterUsername(username);
        sign_in.enterPassword(password);
        sign_in.tapViewPassword();
        sign_in.tapSubmitButton();
        sign_in.tapAllowButton2();
        sign_in.tapAllowButton3();
        sign_in.tapAllowButton1();
    }

    @DataProvider(name = "testData")
    public Object[][] getDataFromExcel() throws IOException {
        return Excel_reader.getTestData();
    }

    @BeforeTest
    public  void mil(){
        Mileage m= new Mileage();
        Mileage.number = m.readNumberFromFile();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
