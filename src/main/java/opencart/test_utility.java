package opencart;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class test_utility{
    public WebDriver driver;
    public String osSystem;
     public String osName=System.getProperty("os.name");
     public Properties properties=new Properties();
     {
         String workingDirectory=System.getProperty("user.dir");
         try {
             properties.load(new FileInputStream(workingDirectory+ File.separator+"config.properties"));
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     public void initialization(){
         if(driver==null){
             ChromeOptions options=new ChromeOptions();
             options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
             if (osName.contains("Mac")){
                System.setProperty("webdriver.chrome.driver","/usr/bin/chromdriver");
                options.addArguments("window-size=1920,1080");
                 options.addArguments("--start-maximized");
                 options.addArguments("--allow-insecure-localhost");
                 options.addArguments("--headless");
                 options.addArguments("--disable-gpu");
                 //Application config
             }
            else if(osName.contains("windows")){
                System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedrver.exe");
                driver=new ChromeDriver(options);
                driver.manage().window().maximize();
                //Application config



             }

     }




        }
}
