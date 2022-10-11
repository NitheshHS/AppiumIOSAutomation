package randomTest;

import cap.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class ScrollGesture extends BaseTest {

    @Test
    public void scrollTest() throws MalformedURLException {
        WebElement ele = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Web View\"`]"));
        mobileGestures.swipeUp(ele);
        ele.click();
        boolean flag = driver.findElement(MobileBy.iOSNsPredicateString("label == \"This is HTML content inside a WKWebView .\"")).isDisplayed();
        System.out.println("Web view is displayed? "+flag);
    }

}
