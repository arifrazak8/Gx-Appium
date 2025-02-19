package Generic;

import POM.Sign_in_POM;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import javax.swing.*;

public class Launch extends Testdata
{
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Show a pop-up dialog to enter input before the test starts
//        username = JOptionPane.showInputDialog("Enter the username:");
//        password = JOptionPane.showInputDialog("Enter the password:");
        location = JOptionPane.showInputDialog("Enter the Dispatch_To:");

        DriverManager.initializeDriver();
        this.driver = DriverManager.getDriver();

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
