package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

import java.util.List;

public class FormPage {

    WebDriver driver;

    public FormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement emailBox;

    @FindBy(xpath = "//div[@id='genterWrapper']//div[@class='col-md-9 col-sm-12']/descendant::label")
    public List<WebElement> genderRadioBtns;

    @FindBy(xpath = "//input[@id='userNumber']")
    public WebElement phoneBox;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    public WebElement dateOfBirthBox;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElement dtpMonth;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElement dtpYear;
    @FindBy(xpath = "//div[@role='listbox']//div//div")
    List<WebElement> dtpDates;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    public WebElement subjectBox;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']//div[@class='col-md-9 col-sm-12']/descendant::div")
    public List<WebElement> hobbyCheckboxes;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    public WebElement chooseFileBtn;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement addressTextbox;

    @FindBy(xpath = "//div[@id='state']")
    public WebElement stateDropdown;
    @FindBy(xpath = "//input[@id='react-select-3-input']")
    public WebElement stateInput;

    @FindBy(xpath = "//div[contains(text(),'Select City')]")
    public WebElement cityDropdown;
    @FindBy(xpath = "//input[@id='react-select-4-input']")
    public WebElement cityInput;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    WebElement thankModal;


    public void setFirstName(String firstName){
        firstNameBox.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastNameBox.sendKeys(lastName);
    }

    public void setEmail(String email){
        emailBox.sendKeys(email);
    }

    public void selectGenderRadioBtn(int index){
        for (WebElement radioBtn : genderRadioBtns){
            if (!radioBtn.isSelected()){
                driver.findElement(By.xpath("//div[@id='genterWrapper']//div[@class='col-md-9 col-sm-12']/descendant::label" + "[" + index + "]")).click();
                break;
            }
        }
    }

    public void setPhoneNum(String phone){
        phoneBox.sendKeys(phone);
    }


    public void setDOB(String year, String month, String date){
        dateOfBirthBox.click();

        Select selectMonth = new Select(dtpMonth);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(dtpYear);
        selectYear.selectByVisibleText(year);

        for (WebElement selectDate : dtpDates){
            if (selectDate.getText().equals(date)){
                selectDate.click();
                break;
            }
        }
    }

    public void setSubject(String subject){
        subjectBox.click();
        subjectBox.sendKeys(subject);
        subjectBox.sendKeys(Keys.ENTER);
    }


    public void selectHobbyCheckbox(int index){
        for (WebElement radioBtn : hobbyCheckboxes){
            if (!radioBtn.isSelected()){
                driver.findElement(By.xpath("//div[@id='hobbiesWrapper']//div[@class='col-md-9 col-sm-12']/descendant::div" + "[" + index + "]")).click();
                break;
            }
        }
    }

    public void clickChooseFileBtn(String file){
        chooseFileBtn.sendKeys(file);
    }

    public void setAddress(String address){
        addressTextbox.sendKeys(address);
    }

    public void setState(String state) {
        stateDropdown.click();
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
    }


    public void setCity(String city){
        cityDropdown.click();
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void clickSubmitBtn(){
        submitBtn.click();
    }

    public boolean checkFormSubmissionSuccess(){
        WaitUtils wait = new WaitUtils();
        wait.waitUntilVisible(driver,thankModal, 10);
        return thankModal.getText().contains("Thanks");
    }
}
