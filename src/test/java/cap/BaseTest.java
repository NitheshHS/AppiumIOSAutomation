package cap;

import FileUtility.JsonUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import randomTest.MobileGestures;

import static reportUtil.ExtentReportManager.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public MobileGestures mobileGestures;
    public  AppiumDriver driver;
    public ExtentReports reports;
    public ExtentTest test;
    public JsonUtility json;


    @BeforeSuite
    public void configure(){
       reports = configureReport();
       AppiumDriverManager.startAppiumServer();

    }
    @BeforeMethod
    public void launchSimulator(ITestResult result) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app","/Users/Nithesha/Library/Developer/Xcode/DerivedData/UIKitCatalog-gccfiyrajnmwahghgvrvdlfabylh/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"15.5");
        capabilities.setCapability(MobileCapabilityType.UDID,"B765AD04-E166-441F-B8B5-57C8640111C4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 12");
        driver = new IOSDriver(AppiumDriverManager.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mobileGestures = new MobileGestures(driver);
        String testName=result.getMethod().getMethodName();
        test = createTest(testName);
    }

    @AfterMethod
    public void closeApp(ITestResult result){
        info("close the application");
        getTestStatus(result, mobileGestures.getScreenshot());
        driver.closeApp();
    }

    @AfterSuite
    public void afterConfig(){
        flushReport();
        AppiumDriverManager.stopAppiumServer();
    }
}
