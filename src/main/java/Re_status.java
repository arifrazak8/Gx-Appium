import io.appium.java_client.AppiumBy;

public class Re_status extends Launch {
    public void re_status(){
        var re_status_btn = driver.findElement(AppiumBy.accessibilityId("Re-Status"));
        re_status_btn.click();
        var location = driver.findElement(AppiumBy.className("android.widget.EditText"));
        location.sendKeys("7004");
        var location_click = driver.findElement(AppiumBy.accessibilityId("7004-Myntra Warehouse-(terminal)"));
        location_click.click();
        var submit_btn = driver.findElement(AppiumBy.accessibilityId("Submit  "));
        submit_btn.click();
    }
}
