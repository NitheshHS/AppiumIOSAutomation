package cap;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.primitives.Bytes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static reportUtil.ExtentReportManager.*;

import java.util.HashMap;
import java.util.Map;

public class MobileGestures {

    private AppiumDriver driver;
    public MobileGestures(AppiumDriver driver){
        this.driver = driver;
    }

    public void swipeUp(WebElement ele) {
        info("swipe for element: "+ele.getClass().getCanonicalName());
        Map<String, Object> param = new HashMap<>();
        param.put("direction", "down");
        param.put("element", ((RemoteWebElement)ele).getId());
        this.driver.executeScript("mobile: swipe", param);
    }

    public void pause(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectPickerWheel(WebElement element){
        info("selecting the picker wheel for element: "+element);
        Map<String, Object> param = new HashMap<>();
        param.put("element",((RemoteWebElement)element).getId());
        param.put("order","next");
        driver.executeScript("mobile: selectPickerWheelValue", param);
    }

    public void tapOnElement(WebElement element, int tapcount, int noOfTouch){
        info("Tap on element: "+element);
        Map<String, Object> param = new HashMap<>();
        param.put("element", ((RemoteWebElement)element).getId());
        param.put("numberOfTaps", tapcount);
        param.put("numberOfTouches", noOfTouch);
        driver.executeScript("mobile: tapWithNumberOfTaps", param);
    }

    public void longPress(WebElement element, int durationInSeconds){
        info("long press on element: "+element+" with duration: "+durationInSeconds);
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", durationInSeconds);
        driver.executeScript("mobile: touchAndHold", params);
    }

    public void awaitAndClick(WebElement element){
        info("Waiting for element to click: "+element);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void typeText(WebElement element, String text){
        info("Waiting for element "+element+" with text: "+text);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public String getScreenshot(){
        info("Taking screenshot");
        return driver.getScreenshotAs(OutputType.BASE64);
    }

    public void scroll(WebElement element, Direction direction){
        info("scrolling in: "+direction+" for element "+element);
        Map<String, Object> params=new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("toVisible",true);
        switch (direction) {
            case UP:
                params.put("direction", Direction.UP.getDirection());
                break;
            case DOWN:
                params.put("direction", Direction.DOWN.getDirection());
                break;
            default:
                info("Element not present: "+element);
                break;
        }
        driver.executeScript("mobile: scroll", params);
    }

    public void scroll(WebElement element) {
        TouchAction touchAction = new TouchAction(driver);
        int swipeCount = 5;
        while (swipeCount > 0) {
            try {
                element.isDisplayed();
                break;
            } catch (Exception e) {
                touchAction
                        .longPress(LongPressOptions
                                .longPressOptions()
                                .withPosition(PointOption
                                        .point(160, 700)))
                        .moveTo(PointOption.point(160, 250))
                        .release().perform();
                swipeCount--;
            }
        }
    }
}

