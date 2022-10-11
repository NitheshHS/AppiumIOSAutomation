package randomTest;

import cap.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DatePicker extends BaseTest {

    @Test
    public void DatePickerTest() throws MalformedURLException {
        driver.findElement(MobileBy.AccessibilityId("Date Picker")).click();
        driver.findElement(MobileBy.iOSNsPredicateString("label == \"Oct 7, 2022\"")).click();
        driver.findElement(MobileBy.AccessibilityId("Show year picker")).click();
        MobileElement monthPicker = (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString("value == \"October\""));
        //monthPicker.setValue("May");
        MobileElement yearPicker = (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString("value == \"2022\""));
        //yearPicker.setValue("2024");
        mobileGestures.pause(5);
        mobileGestures.selectPickerWheel(monthPicker);
        mobileGestures.selectPickerWheel(yearPicker);
        System.out.println("month: "+monthPicker.getAttribute("value")+"\n"+"Year: "+yearPicker.getAttribute("value"));

    }
}
