package SamplePackage1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenarios extends BaseClass {

	@Test(priority = 1)
	public void VerifyPackageSelection() {
				
		driver.get("https://connect-th.beinsports.com/en");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 100);

		driver.findElement(By.name("Subscribe")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[4]")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div[2]/div[2]/div[2]/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("FirstName")));
		assertHeaderMessage("Register - beIN SPORTS CONNECT");
		  
		}
	@Test(priority = 2)
	public void VerifyRegistiration() {
		
		driver.findElement(By.name("FirstName")).sendKeys("Demo");
		driver.findElement(By.name("LastName")).sendKeys("Test");
		WebDriverWait wait = new WebDriverWait(driver, 100);

		Random email=new Random();
	    int id = email.nextInt();


		driver.findElement(By.name("EmailOrPhone")).sendKeys("abcde"+id+"@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("Abc123%");
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div[2]/div[11]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("close")));	
		assertHeaderMessage("Basket - beIN SPORTS CONNECT");
			}
	
	@Test(priority = 3)
	public void VerifyPaymentPanel() {
		
		driver.findElement(By.id("close")).click();  
		driver.findElement(By.xpath("//*[@id=\"form-basket\"]/div[1]/div[4]/div[1]/label")).click();
		driver.findElement(By.name("pay-now")).click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Ecom_Payment_Card_Name")));
		driver.findElement(By.name("Ecom_Payment_Card_Name")).sendKeys("DemoTest");		
		driver.findElement(By.name("Ecom_Payment_Card_Number")).sendKeys("1234123412341234");
		
		Select dropdown = new Select(driver.findElement(By.id("Ecom_Payment_Card_ExpDate_Month")));
		dropdown.selectByIndex(2);
		Select dropdown1 = new Select(driver.findElement(By.id("Ecom_Payment_Card_ExpDate_Year")));
		dropdown1.selectByIndex(2);
		driver.findElement(By.name("Ecom_Payment_Card_Verification")).sendKeys("123");	
		
		driver.findElement(By.name("payment")).click();
		
		
		assertAlertMessage("This field is not valid.: 'Card number'");

	}
	
	public void assertHeaderMessage(String expectedMessages) {
		
		  Assert.assertEquals((driver.getTitle()), expectedMessages);
		  }
	public void assertAlertMessage(String expectedMessages) {
		
		  Assert.assertEquals((driver.switchTo().alert().getText()), expectedMessages);
		  }
	}

