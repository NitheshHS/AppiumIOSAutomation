package cap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static reportUtil.ExtentReportManager.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LaunchSimulator {
    public MobileGestures mobileGestures;
    public  AppiumDriver driver;
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeSuite
    public void configure(){
       reports = configureReport();
    }
    @BeforeMethod
    public void launchSimulator(ITestResult result) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app","/Users/Nithesha/Library/Developer/Xcode/DerivedData/UIKitCatalog-gccfiyrajnmwahghgvrvdlfabylh/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"15.5");
        capabilities.setCapability(MobileCapabilityType.UDID,"B765AD04-E166-441F-B8B5-57C8640111C4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 12");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("print success");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mobileGestures = new MobileGestures(driver);
        String testName=result.getMethod().getMethodName();
        test = createTest(testName);
    }

    @AfterMethod
    public void closeApp(ITestResult result){
        info("close the application");
        if(result.getStatus() == ITestResult.SUCCESS){
            info("Test pass");
        }else if(result.getStatus() == ITestResult.SKIP){
            info("Test skipped");
            info("cause: "+result.getThrowable().getMessage());
        }else if(result.getStatus() == ITestResult.FAILURE){
            info("Test fail");
            test.addScreenCaptureFromBase64String(mobileGestures.getScreenshot());
        }

        driver.closeApp();
    }

    @AfterSuite
    public void afterConfig(){
        flushReport();
    }
}
