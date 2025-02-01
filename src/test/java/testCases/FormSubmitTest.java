package testCases;


import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.ScrollUtil;

public class FormSubmitTest extends Base {



    ScrollUtil scrollUtil;

    /// Data provider for form test.
    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"Sithara", "Dilmini", "sith@gmail.com", 1, "0778665643", "2002", "April", "8", "Physics", 1, "\\C:\\Users\\User\\Desktop\\cute-girl-working-on-computer-cartoon-icon-illustration-people-and-technology-icon-concept-isolated-premium-flat-cartoon-style-vector.jpg", "galle", 1, 1}
        };
    }

    @Test(dataProvider = "testData")

    public void formSubmissionTest(String firstName, String lastName, String email, int genderIndex, String phone, String year, String month, String date, String subject, int hobbyIndex, String file, String address, int stateIndex, int cityIndex) {

        /// Initialize FormPage
        FormPage formPage = new FormPage(getDriver());

        /// Fill the form and submit
        formPage.setFirstName(firstName);
        formPage.setLastName(lastName);
//        scrollUtil.scrollAndClick(getDriver(), formPage.emailBox);
        formPage.setEmail(email);
//        scrollUtil.scrollAndClick(getDriver(), (WebElement) formPage.phoneBox);
        formPage.selectGenderRadioBtn(genderIndex);
//        scrollUtil.scrollAndClick(getDriver(), formPage.phoneBox);
        formPage.setPhoneNum(phone);
//        scrollUtil.scrollAndClick(getDriver(), formPage.dateOfBirthBox);
        formPage.setDOB(year, month, date);
//        scrollUtil.scrollAndClick(getDriver(), formPage.subjectBox);
//        formPage.setSubject(subject);
//        scrollUtil.scrollAndClick(getDriver(), (WebElement) formPage.hobbyCheckboxes);
//        formPage.selectHobbyCheckbox(hobbyIndex);
//        scrollUtil.scrollAndClick(getDriver(), formPage.chooseFileBtn);
//        formPage.clickChooseFileBtn(file);
//        scrollUtil.scrollAndClick(getDriver(), formPage.addressTextbox);
//        formPage.setAddress(address);
//        scrollUtil.scrollAndClick(getDriver(), formPage.stateDropdown);
//        formPage.setState(stateIndex);
//        scrollUtil.scrollAndClick(getDriver(), formPage.cityDropdown);
//        formPage.setCity(cityIndex);

        /// Submit form
        scrollUtil.doScrolling(getDriver(), 400);
        formPage.clickSubmitBtn();

        /// Verify form submission
        Assert.assertTrue(formPage.checkFormSubmissionSuccess(), "Form submission failed");
    }


}