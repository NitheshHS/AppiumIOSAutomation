package PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class PickerViewPage extends Pages{
    public PickerViewPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Red color component value")
    private MobileElement red_color_component;

    @iOSXCUITFindBy(accessibility = "Green color component value")
    private MobileElement green_color_component;

    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private MobileElement blue_color_component;

    public void setComponentValue() throws Exception {
        String red = json.getJSONValue("PICKER_VIEW", "red_color_component");
        String green = json.getJSONValue("PICKER_VIEW", "green-color-component");
        String blue = json.getJSONValue("PICKER_VIEW", "blue-color_component");
        red_color_component.sendKeys(red);
        green_color_component.sendKeys(green);
        blue_color_component.sendKeys(blue);
        mobileGestures.pause(2);
        Assert.assertEquals(red_color_component.getAttribute("value"),red);
        Assert.assertEquals(green_color_component.getAttribute("value"), green);
        Assert.assertEquals(blue_color_component.getAttribute("value"), blue);
    }

}
