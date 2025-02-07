import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class Launch implements Constant
{
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void setUp() throws InterruptedException {
        var options = new BaseOptions<>()
                .amend("platformName",platformName_value)
                .amend("appium:platformVersion",platformVersion_value)
//                .amend("disableSuppressAccessibilityService",true)
//                .amend("autoGrantPermissions",true)
                .amend("appium:deviceName", deviceName_value)
                .amend("appium:app",app_value )
                .amend("appium:automationName",automationName_value)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //For signIn
        new Sign_In().Signin();

    }

    private URL getUrl() {
        try {
            return new URL(Appium_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for Appium Server", e);
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
