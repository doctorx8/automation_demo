import opencart.BaseClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class frontendTestNGRunner extends BaseClass {

    @BeforeClass
    public void openBrowser(){
        initialization();
    }
    @Test
    public void TC_1(){
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
