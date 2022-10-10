package cap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;


public class ScrollGesture extends LaunchSimulator{

    @Test
    public void scrollTest() throws MalformedURLException {
        WebElement ele = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Web View\"`]"));
        mobileGestures.swipeUp(ele);
        ele.click();
        boolean flag = driver.findElement(MobileBy.iOSNsPredicateString("label == \"This is HTML content inside a WKWebView .\"")).isDisplayed();
        System.out.println("Web view is displayed? "+flag);
    }

}
