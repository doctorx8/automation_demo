package opencart.frontend;
import opencart.BaseClass;
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
    public RegisterPage() {
        PageFactory.initElements(driver,this);
    }


}
