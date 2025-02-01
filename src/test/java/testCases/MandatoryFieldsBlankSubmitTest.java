package testCases;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.ScrollUtil;
import utils.WaitUtils;

public class MandatoryFieldsBlankSubmitTest extends Base {

    @Test
    public void mandatoryBlankSubmission() throws InterruptedException {

        FormPage formPage = new FormPage(getDriver());

        ScrollUtil scrollUtil = new ScrollUtil();
        scrollUtil.scrollAndClick(getDriver(), formPage.submitBtn);

        // Check if the input fields have red borders
        Thread.sleep(2000);
        boolean isFirstNameBoxRed = formPage.firstNameBox.getCssValue("border-color").equals("rgb(220, 53, 69)");
        boolean isLastNameBoxRed = formPage.lastNameBox.getCssValue("border-color").equals("rgb(220, 53, 69)");
        boolean isPhoneBoxRed = formPage.phoneBox.getCssValue("border-color").equals("rgb(220, 53, 69)");


        // Check if any of the radio buttons have a red border
        boolean isRadioBtnRed = false;
        for (WebElement radioBtn : formPage.genderRadioBtns) {
            String radioBtnBorderColor = radioBtn.getCssValue("border-color");
            if (radioBtnBorderColor.equals("#dc3545")) {
                isRadioBtnRed = true;
                break;
            }
        }

        // Check if all required fields have red borders
        boolean isRequiredFieldsRed = isFirstNameBoxRed && isLastNameBoxRed && isPhoneBoxRed ;

        // Assert that all required fields are red
        Assert.assertTrue(isRequiredFieldsRed, "Form submitted. Required fields did not get highlighted");
    }
}
