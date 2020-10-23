package practice;



import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;





class Loginmethod {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();


@BeforeTest
	void launchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saikumar.yadagiri\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		
}
		
@Test(priority=1)
	void login() throws IOException {
	try {
	FileInputStream fis = new FileInputStream("C:\\Users\\saikumar.yadagiri\\Desktop\\data.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Sheet1"); // workbook.getSheetAt(0)
	workbook.createSheet("Name");
	//Count the number of rows
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	System.out.println(rowCount);

	for(int i=1;i<=rowCount;i++) {		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		driver.findElement(By.id("passwd")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		
	String message2=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).getText();
		if(message2.equalsIgnoreCase("Sign out"))
		driver.findElement(By.className("logout")).click();
		
		}
	}
	finally {
		driver.navigate().refresh();
		
	}
	}
		
}	