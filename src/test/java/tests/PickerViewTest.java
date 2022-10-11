package tests;

import PageFactory.HomePage;
import cap.BaseTest;
import org.testng.annotations.Test;

public class PickerViewTest extends BaseTest {

   @Test
    public void verifyPickerView() throws Exception {
        new HomePage(driver)
                .clickOnPickerView()
                .setComponentValue();
    }
}
