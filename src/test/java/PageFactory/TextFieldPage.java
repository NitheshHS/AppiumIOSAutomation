package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;

public class TextFieldPage extends Pages{

    AppiumDriver driver;
    public TextFieldPage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    @iOSXCUITFindBy(xpath = "(//*[@name='DEFAULT']/following-sibling::*/child::XCUIElementTypeTextField[@value='Placeholder text'])[1]")
    private WebElement defaultTextField;

    public void typeTextIntoField(){
        mobileGestures.typeText(defaultTextField, "abc");
    }
}
