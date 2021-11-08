import opencart.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class frontendTestNGRunner extends BaseClass {
    @BeforeClass
    public void openBrowser(){
        initialization();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
