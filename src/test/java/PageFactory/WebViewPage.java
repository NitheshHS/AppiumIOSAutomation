package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebViewPage extends Pages{

    public WebViewPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "This is HTML content inside a WKWebView .")
    private MobileElement webViewText;

    public void verifyWebViewText(){
        Assert.assertTrue(webViewText.isDisplayed());
    }
}
