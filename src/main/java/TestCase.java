import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestCase extends Launch {

    @Test
    public void TC1() throws InterruptedException {
        //If clock_in required.
        try {
            new Clock_In().Clock_in();
        } catch (Exception e) {
            System.out.println("Clock_in not reguired "+ e.getMessage());
        }

    }

}
