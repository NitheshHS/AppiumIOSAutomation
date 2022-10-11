package tests;

import PageFactory.HomePage;
import cap.LaunchSimulator;
import org.testng.annotations.Test;

public class PickerViewTest extends LaunchSimulator {

    @Test
    public void verifyPickerView() throws Exception {
        new HomePage(driver)
                .clickOnPickerView()
                .setComponentValue();
    }
}
