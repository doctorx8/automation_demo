package opencart;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class BaseClass {
    public static WebDriver driver;
    public static String osName=System.getProperty("os.name");
     public static Properties properties=new Properties();
     public static ResourceBundle resourceBundle ;
    static  {
         String workingDirectory=System.getProperty("user.dir");
         try {
             properties.load(new FileInputStream(workingDirectory+ File.separator+"config.properties"));
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     public static void initialization(){
         if(driver==null){
             ChromeOptions options=new ChromeOptions();
             options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
             System.out.println(osName);
             if (osName.contains("Mac")){
                System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
                options.addArguments("window-size=1920,1080");
                 options.addArguments("--start-maximized");
                 options.addArguments("--allow-insecure-localhost");
                 options.addArguments("--headless");
                 options.addArguments("--disable-gpu");
                 driver=new ChromeDriver(options);
                 //Application config
             }
            else if(osName.toLowerCase().contains("windows")){
                System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
                driver=new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get( properties.getProperty("frontend"));

                 System.out.println("Running on Windows mode");
            }
         }
     }
     public static void closeBrowser(){
         driver.close();
         driver.quit();
         driver=null;
     }


}
