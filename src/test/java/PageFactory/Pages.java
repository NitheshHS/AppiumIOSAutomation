package PageFactory;

import cap.MobileGestures;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    public AppiumDriver driver;
    public MobileGestures mobileGestures;

    public Pages(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        mobileGestures = new MobileGestures(driver);
    }
}
