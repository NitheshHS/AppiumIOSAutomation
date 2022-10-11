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

import static reportUtil.ExtentReportManager.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public MobileGestures mobileGestures;
    public  AppiumDriver driver;
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeSuite
    public void configure(){
       reports = configureReport();
       AppiumDriverManager.getInstance().startAppiumServer();

    }
    @BeforeMethod
    public void launchSimulator(ITestResult result) throws MalformedURLException {

        driver = new IOSDriver(AppiumDriverManager.getInstance().getUrl(), CapabilityLib
                .getInstance().getDeviceCapability("iPhone 12"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        AppiumDriverManager.getInstance().stopAppiumServer();
    }
}
