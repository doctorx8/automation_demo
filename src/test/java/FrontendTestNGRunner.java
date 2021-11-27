import opencart.BaseClass;
import opencart.frontend.HomePage;
import opencart.frontend.RegisterPage;
import opencart.frontend.SuccessPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class FrontendTestNGRunner extends BaseClass {

    HomePage homePage;
    RegisterPage registerPage;
    SuccessPage successPage;
    @BeforeClass
    public void openBrowser(){
        initialization();
        homePage=new HomePage();
        registerPage=new RegisterPage();
        successPage=new SuccessPage();
    }
    @Test
    public void TC_1_createAccount()  {
        homePage.clickOnMyAccountButton();
        homePage.clickOnRegisterLink();
        registerPage.fillInFirstName();
        registerPage.fillInLastName();
        registerPage.fillInEmail();
        registerPage.fillInTelNumber();
        registerPage.fillInPassWord();
        registerPage.fillInConfirmedPassWord();
        registerPage.clickOnPrivacyPolicyCheckBox();
        registerPage.clickOnContinueButton();
        Assert.assertTrue(successPage.verifyAccountCreatedSuccessMessage());
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
