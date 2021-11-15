package opencart.frontend;

import opencart.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BaseClass {
        @FindBy(xpath = "//span[text()='My Account']")
        WebElement myAccountButton;
        @FindBy(css = "a[href='http://localhost/opencart/upload/index.php?route=account/register']")
        WebElement registerLink;
    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    public void clickOnMyAccountButton(){
        myAccountButton.click();
    }
    public void clickOnRegisterLink(){
        registerLink.click();
    }
}
