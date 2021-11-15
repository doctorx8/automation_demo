package opencart.frontend;

import opencart.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage extends BaseClass {
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement accountCreatedSuccessMessage;
    public SuccessPage() {
        PageFactory.initElements(driver,this);
    }
    public boolean verifyAccountCreatedSuccessMessage(){
        return accountCreatedSuccessMessage.isDisplayed();
    }

}
