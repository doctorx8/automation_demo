package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a/span[text()='My Account']")
    WebElement linkMyAccount;
    @FindBy(linkText = "Register")
    WebElement linkRegister;
    @FindBy(linkText = "Login")
    WebElement linkLogin;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickMyAccount(){
        linkMyAccount.click();
    }
    public void clickLinkRegister(){
        linkRegister.click();
    }
    public void clickLinkLogin(){
        linkLogin.click();
    }

}
