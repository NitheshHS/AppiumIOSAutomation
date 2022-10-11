package tests;

import PageFactory.HomePage;
import cap.BaseTest;
import org.testng.annotations.Test;

public class TextFieldTest extends BaseTest {

   @Test
    public void enterValueIntoTextField(){
        new HomePage(driver)
                .clickOnTextField()
                .typeTextIntoField();

    }


}
