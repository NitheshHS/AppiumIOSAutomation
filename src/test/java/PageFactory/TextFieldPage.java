package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;

public class TextFieldPage extends Pages{

    AppiumDriver driver;
    public TextFieldPage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    @iOSXCUITFindBy(xpath = "(//*[@name='DEFAULT']/following-sibling::*/child::XCUIElementTypeTextField[@value='Placeholder text'])[1]")
    private WebElement defaultTextField;

    @SneakyThrows
    public void typeTextIntoField(){
        String text = json.getJSONValue("TEXT_FIELD","text");
        mobileGestures.typeText(defaultTextField, text);
        Assert.assertTrue(defaultTextField.getAttribute("value").contains(text));
    }
}
