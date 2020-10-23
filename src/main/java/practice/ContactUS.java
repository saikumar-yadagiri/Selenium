package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 

public class ContactUS {
    WebDriver driver = null;
    
    @BeforeTest
    public void SetDriver(){
    
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\saikumar.yadagiri\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
    waitForLoad(driver);
    driver.manage().window().maximize();
    
    }

 

    @Test
    public void ContactUS(){
        WebDriverWait wait10 = new WebDriverWait(driver,50);
        wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title=\"Contact Us\"]")));
        driver.findElement(By.xpath("//*[@title=\"Contact Us\"]")).click();
        waitForLoad(driver);
        String Contact_title = driver.getTitle();
        Assert.assertEquals(Contact_title,"Contact us - My Store", "Page is not navigating to Contact Us");
        System.out.println("Contact Us is displayed");
        Select choose = new Select(driver.findElement(By.name("id_contact")));
        choose.selectByVisibleText("Customer service");
        driver.findElement(By.xpath("//*[@name=\"from\"]")).sendKeys("saikumar@gmail.com");
        driver.findElement(By.xpath("//*[@name=\"id_order\"]")).sendKeys("99999");
        driver.findElement(By.xpath("//*[@name=\"message\"]")).sendKeys("order not delivered");
        driver.findElement(By.xpath("//*[@name=\"submitMessage\"]")).click();
        WebDriverWait wait9 = new WebDriverWait(driver,50);
        wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"alert alert-success\"]")));
        String alert_message = driver.findElement(By.xpath("//*[@class=\"alert alert-success\"]")).getText();
        Assert.assertEquals(alert_message,"Your message has been successfully sent to our team.", "Request is not created");
        System.out.println("Request has sent to contact team");
        
    }    
            
    
    public void  waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
               public Boolean apply(WebDriver driver) {
                     return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
               }
        };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }
            
    @AfterTest
    public void closeDriver() {    
        
    driver.close();
    
    }

 


}
 