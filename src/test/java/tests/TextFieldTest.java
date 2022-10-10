package tests;

import PageFactory.HomePage;
import cap.LaunchSimulator;
import org.testng.annotations.Test;

public class TextFieldTest extends LaunchSimulator {

    @Test
    public void enterValueIntoTextField(){
        new HomePage(driver)
                .clickOnTextField()
                .typeTextIntoField();

    }


}
