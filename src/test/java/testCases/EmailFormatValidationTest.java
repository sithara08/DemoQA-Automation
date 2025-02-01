package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.ScrollUtil;

public class EmailFormatValidationTest extends Base {

    ScrollUtil scrollUtil = new ScrollUtil();

    /// Data provider for appointment test.
    @DataProvider
    public Object[][] appointmentData() {
        return new Object[][]{
                {"Sithara", "Dilmini", "sitcom", 1, "0778665643", "2002", "April", "8"},
                {"Sithara", "Dilmini", "sith@gailcom", 1, "0778665643", "2002", "April", "8"}
        };
    }

    @Test(testName = "Make Appointment Test", dataProvider = "appointmentData")
    public void invalidEmailSubmission(String firstName, String lastName, String email, int genderIndex, String phone, String year, String month, String date) {

        /// Initialize AppointmentPage
        FormPage formPage = new FormPage(getDriver());

        /// Fill appointment form and submit
        formPage.setFirstName(firstName);
        formPage.setLastName(lastName);
        formPage.setEmail(email);
        scrollUtil.scrollAndClick(getDriver(), formPage.phoneBox);
        formPage.selectGenderRadioBtn(genderIndex);
        formPage.setPhoneNum(phone);

        /// Submit form
        formPage.clickSubmitBtn();

        scrollUtil.scrollAndClick(getDriver(), formPage.emailBox);
        boolean isEmailBoxRed = formPage.emailBox.getCssValue("border-color").equals("rgb(220, 53, 69)");

        Assert.assertTrue(isEmailBoxRed, "Email is not validated.");
    }
}
