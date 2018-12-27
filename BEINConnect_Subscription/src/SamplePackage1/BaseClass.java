package SamplePackage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;

	@BeforeTest
	public void StartUp() {
		 
	    //Start Browser
		System.setProperty("webdriver.chrome.driver","C:\\...\\eclipse-workspace\\BEINConnect_Subscription\\ExeFile\\chromedriver.exe");
		//Change with your local path of the chromedriver.exe

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    
	}
	 
	@AfterTest
	public void tearDown(){
	 
	    //Close driver
	    driver.quit();
	 
	}
}
