import opencart.BaseClass;

import opencart.frontend.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class FrontendTestNGRunner extends BaseClass {

    HomePage homePage;
    @BeforeClass
    public void openBrowser(){
        initialization();
        homePage=new HomePage();
    }
    @Test
    public void TC_1(){
        homePage.clickOnMyAccountButton();
        homePage.clickOnRegisterLink();
    }
    @AfterClass(enabled = false)
    public void tearDown(){
        closeBrowser();
    }
}
