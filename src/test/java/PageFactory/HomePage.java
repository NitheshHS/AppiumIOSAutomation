package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Pages{

    @iOSXCUITFindBy(accessibility = "Activity Indicators")
    private WebElement activityIndicators;

    @iOSXCUITFindBy(accessibility = "Search")
    private WebElement search;

    @iOSXCUITFindBy(accessibility = "Steppers")
    private WebElement steppers;

    @iOSXCUITFindBy(xpath = "//*[@name='Text Fields']")
    private WebElement textFields;

    @iOSXCUITFindBy(accessibility = "Picker View")
    private WebElement pickerView;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public TextFieldPage clickOnTextField(){
        mobileGestures.awaitAndClick(textFields);
        return  new TextFieldPage(driver);
    }

    public PickerViewPage clickOnPickerView(){
        mobileGestures.awaitAndClick(pickerView);
        return new PickerViewPage(driver);
    }
}
