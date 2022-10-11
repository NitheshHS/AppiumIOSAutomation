package tests;

import PageFactory.HomePage;
import cap.BaseTest;
import org.testng.annotations.Test;

public class WebViewTest extends BaseTest {

    @Test
    public void verifyWebViewText(){
        new HomePage(driver)
                .clickOnWebView()
                .verifyWebViewText();
    }
}
