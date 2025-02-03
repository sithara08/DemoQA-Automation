package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.ScrollUtil;

public class EmailFormatValidationTest extends Base {
    /// Data provider for email format validation.
    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Sithara", "Dilmini", "sitcom", 1, "0778665643", "2002", "April", "8"},
                {"Sithara", "Dilmini", "sith@gailcom", 1, "0778665643", "2002", "April", "8"}
        };
    }

    @Test(dataProvider = "data")
    public void invalidEmailSubmission(String firstName, String lastName, String email, int genderIndex, String phone, String year, String month, String date) throws InterruptedException {

        /// Initialize FormPage
        FormPage formPage = new FormPage(getDriver());

        /// Initialize ScrollUtil
        ScrollUtil scrollUtil = new ScrollUtil();

        /// Fill the form and submit
        formPage.setFirstName(firstName);
        formPage.setLastName(lastName);
        formPage.setEmail(email);
        scrollUtil.scrollAndClick(getDriver(), formPage.phoneBox);
        formPage.selectGenderRadioBtn(genderIndex);
        formPage.setPhoneNum(phone);

        /// Submit form
        formPage.clickSubmitBtn();

        Thread.sleep(3000);

        /// Scroll up to email field and get its border color
        scrollUtil.scrollAndClick(getDriver(), formPage.emailBox);
        boolean isEmailBoxRed = formPage.emailBox.getCssValue("border-color").equals("rgb(220, 53, 69)");

        /// Verify email format validation successful
        Assert.assertTrue(isEmailBoxRed, "Email is not validated.");
    }
}
