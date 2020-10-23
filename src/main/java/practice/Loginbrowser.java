package practice;

 

import java.util.List;
import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

 

import Basepages.Base;
import pages.Launchbrowser;

 

public class Loginbrowser {
    
    private Launchbrowser Launchbrowser = null;
    public Loginbrowser () {
    Launchbrowser = new Launchbrowser();
    }
    
        WebDriver driver;
        @Test
        public void VerifyBrowserOpen() {
        
        System.setProperty("webdriver.chrome.driver","C:\\Users\\saikumar.yadagiri\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(Launchbrowser.dresses).click();
        //scrolling
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,50)");
         driver.findElement(Launchbrowser.Product1).click();
         driver.findElement(Launchbrowser.Addtocart).click();
         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         driver.findElement(Launchbrowser.Closewindow).click(); 
         driver.navigate().back();
         JavascriptExecutor sj = (JavascriptExecutor) driver;
         sj.executeScript("window.scrollBy(0,50)");
         driver.findElement(Launchbrowser.Product2).click();
         driver.findElement(Launchbrowser.Addtocart).click();
         driver.findElement(Launchbrowser.Closewindow).click(); 
         driver.navigate().back();
         driver.findElement(Launchbrowser.Shoppingcart).click();
         WebElement Cart=driver.findElement(Launchbrowser.successmessage);
         if(Cart.isDisplayed()) 
         System.out.println("Shopping cart is displayed");
         else
            System.out.println("Shopping cart is not displayed");
         List<WebElement> tablecolumn =driver.findElements(Launchbrowser.colno) ; 
         int size=tablecolumn.size();
         System.out.println(size);
         Assert.assertTrue(tablecolumn.size()==2,"No of columns is not 2");
         System.out.println("2 products added to cart");
        }    
        
           
        
        
         }
     
        
                
        
        

 


        

 

