package randomTest;

import cap.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LongPressGesture extends BaseTest {

    @Test
    public void longPressTest() throws MalformedURLException {
        driver.findElement(MobileBy.AccessibilityId("Steppers")).click();
        WebElement ele=driver.findElement(MobileBy.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[3]"));
       mobileGestures.pause(5);
       mobileGestures.longPress(ele, 10);

    }
}
