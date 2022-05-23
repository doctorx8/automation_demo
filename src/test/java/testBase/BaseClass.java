package testBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown(){
       driver.close();
    }
    public String randomStringGenerator(int stringLength){
        String generatedString = RandomStringUtils.randomAlphabetic(stringLength);
        return generatedString;
    }
    public int randomNumberGenerator(int numberLength){
        String generatedNumber=RandomStringUtils.randomNumeric(numberLength);
        return Integer.parseInt(generatedNumber);
    }


}
