import opencart.BaseClass;

;
import opencart.frontend.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class frontendTestNGRunner extends BaseClass {
    HomePage homePage=new HomePage();
    @BeforeClass
    public void openBrowser(){
        initialization();
    }
    @Test
    public void TC_1(){
        homePage.clickOnMyAccountButton();
    }
    @AfterClass(enabled = false)
    public void tearDown(){
        closeBrowser();
    }
}