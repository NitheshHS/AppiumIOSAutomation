package cap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LongPressGesture extends LaunchSimulator{

    @Test
    public void longPressTest() throws MalformedURLException {
        driver.findElement(MobileBy.AccessibilityId("Steppers")).click();
        WebElement ele=driver.findElement(MobileBy.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[3]"));
       mobileGestures.pause(5);
       mobileGestures.longPress(ele, 10);

    }
}
