package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {
    WebDriver driver;
    public AccountRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#input-firstname")
    WebElement firstNameTextField;
    @FindBy(css = "#input-lastname")
    WebElement lastNameTextField;
    @FindBy(css = "#input-email")
    WebElement emailTextField;
    @FindBy(css = "#input-telephone")
    WebElement telephoneTextField;
    @FindBy(css = "#input-password")
    WebElement passWordTextField;
    @FindBy(css = "#input-confirm")
    WebElement passWordConfirmTextField;
    @FindBy(xpath = "//label[@class='radio-inline']/input[@value='1']")
    WebElement newsletterCheckboxYesOption;
    @FindBy(xpath = "//label[@class='radio-inline']/input[@value='2']")
    WebElement newsletterCheckBoxNoOption;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privatePolicyAgreeCheckBox;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement continueButton;
    public void inputFirstName(String firstName){
        firstNameTextField.sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        lastNameTextField.sendKeys(lastName);
    }
    public void inputEmail(String email){
        emailTextField.sendKeys(email);
    }
    public void inputTelNumber(int telNumber){
        telephoneTextField.sendKeys(String.valueOf(telNumber));
    }
    public void inputPassWord(){

    }
}
