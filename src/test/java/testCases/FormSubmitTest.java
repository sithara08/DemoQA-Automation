package testCases;


import base.Base;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.ScrollUtil;

public class FormSubmitTest extends Base {
    /// Data provider for form test.
    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"Sithara", "Dilmini", "sith@gmail.com", 1, "0778665643", "2002", "April", "8", "physics", 2, "C:\\Users\\User\\Downloads\\TestLeaf Logo.png", "galle", "haryana", "panipat"}
        };
    }

    @Test(dataProvider = "testData")
    public void formSubmissionTest(String firstName, String lastName, String email, int genderIndex, String phone, String year, String month, String date, String subject, int hobbyIndex, String file, String address, String state, String city) {
        /// Initialize FormPage
        FormPage formPage = new FormPage(getDriver());

        /// Initialize ScrollUtil
        ScrollUtil scrollUtil = new ScrollUtil();

        /// Fill the form and submit
        formPage.setFirstName(firstName);
        formPage.setLastName(lastName);
        formPage.setEmail(email);
        formPage.selectGenderRadioBtn(genderIndex);
        formPage.setPhoneNum(phone);
        formPage.setDOB(year, month, date);
        formPage.setSubject(subject);
        formPage.selectHobbyCheckbox(hobbyIndex);
        formPage.clickChooseFileBtn(file);
        scrollUtil.scrollAndClick(getDriver(), formPage.addressTextbox);
        formPage.setAddress(address);
        scrollUtil.scrollAndClick(getDriver(), formPage.stateDropdown);
        formPage.setState(state);
        scrollUtil.scrollAndClick(getDriver(), formPage.cityDropdown);
        formPage.setCity(city);

        /// Submit form
        scrollUtil.scrollAndClick(getDriver(), formPage.submitBtn);

        /// Verify form submission
        Assert.assertTrue(formPage.checkFormSubmissionSuccess(), "Form submission failed");
    }
}