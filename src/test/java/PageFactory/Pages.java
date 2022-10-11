package PageFactory;

import FileUtility.JsonUtility;
import randomTest.MobileGestures;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    public AppiumDriver driver;
    public MobileGestures mobileGestures;
    public JsonUtility json;

    public Pages(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        mobileGestures = new MobileGestures(driver);
        json = new JsonUtility().loadJsonFile();
    }
}
