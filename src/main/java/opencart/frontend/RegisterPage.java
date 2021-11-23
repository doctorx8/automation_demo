package opencart.frontend;
import com.opencsv.CSVWriter;
import opencart.BaseClass;
import opencart.TestData_Holder;
import opencart.utility.CsvWR;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


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
    public void fillInEmail()  {
        String email=RandomStringUtils.randomAlphabetic(3,6)+"@"+RandomStringUtils.randomAlphabetic(3,6)+".com";
        TestData_Holder.setEmail(email);
        List<String[]> csvData =CsvWR.createCsvDataSpecial();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\xuekr\\IdeaProjects\\automation_demo\\testdata.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        emailTextField.sendKeys(email);
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
