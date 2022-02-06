package opencart.frontend;

import opencart.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage extends BaseClass {
    @FindBy(css = "div #content p")
    WebElement accountCreatedSuccessMessage;
    public SuccessPage() {
        PageFactory.initElements(driver,this);
    }
    public boolean verifyAccountCreatedSuccessMessage(){
        return accountCreatedSuccessMessage.isDisplayed();
    }

}
