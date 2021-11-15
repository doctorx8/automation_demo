package opencart.frontend;
import opencart.BaseClass;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {
    @FindBy(id = "input-firstname")
    WebElement firstNameTextField;
    @FindBy(id = "input-lastname")
    WebElement lastNameTextField;
    @FindBy(id = "input-email")
    WebElement emailTextField;
    @FindBy(id = "input-telephone")
    WebElement telephoneTextField;
    @FindBy(id = "input-password")
    WebElement passwordTextField;
    @FindBy(id = "input-confirm")
    WebElement passWordConfirmTextField;
    @FindBy(css = "input[type='checkbox']")
      WebElement privacyPolicyAgreedCheckBox;
    @FindBy(css = "input[type='submit']")
    WebElement continueButton;
    String passWord;
    public RegisterPage() {
        PageFactory.initElements(driver,this);
    }
    public void fillInFirstName(){
        firstNameTextField.sendKeys(RandomStringUtils.randomAlphabetic(3,6));
    }
    public void fillInLastName(){
        lastNameTextField.sendKeys(RandomStringUtils.randomAlphabetic(3,6));
    }
    public void fillInEmail(){
        emailTextField.sendKeys(RandomStringUtils.randomAlphabetic(3,6)+"@"+RandomStringUtils.randomAlphabetic(3,6)+".com");
    }
    public void fillInTelNumber(){
        telephoneTextField.sendKeys(org.apache.commons.lang3.RandomStringUtils.randomNumeric(8));
    }
    public void fillInPassWord(){
        passWord=RandomStringUtils.randomAlphanumeric(5).toUpperCase()+RandomStringUtils.randomNumeric(8);
        passwordTextField.sendKeys(passWord);

    }
    public void fillInConfirmedPassWord(){
        passWordConfirmTextField.sendKeys(passWord);
    }
    public void clickOnPrivacyPolicyCheckBox(){
        privacyPolicyAgreedCheckBox.click();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }

}
