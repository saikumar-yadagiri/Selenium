package Basepages;


import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//import com.sun.org.slf4j.internal.Logger;

 



 

public class Base {
    
    public static WebDriver driver;
   // public static Logger logger;
    @BeforeClass
    
    
    public void setup() {
        //logging into file
//        logger=Logger.getLogger("Demo");
//        PropertyConfigurator.configure("Log4j.properties");
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\bindumadhuri.kottu\\Desktop\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://automationpractice.com/index.php");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown() {
    driver.quit();
    }

 

}
 