package opencart.frontend;

import opencart.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BaseClass {
        @FindBy(xpath = "//i[@class='fa fa-user']")
        WebElement myAccountLink;
        @FindBy(xpath = "//a[text()='Register']")
        WebElement registerLink;
    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    public void clickOnMyAccountButton(){
        myAccountLink.click();
    }
    public void clickOnRegisterLink(){
        registerLink.click();
    }
}
