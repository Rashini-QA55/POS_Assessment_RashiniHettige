package com.postest.org.pos_assessment;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.pos.elements.POS_TestPage_Elements;
import com.pos.pages.POS_testPages;

public class AbstractBaseTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//initialize object of the page factory elements class
	POS_TestPage_Elements posTestPageElements;
	POS_testPages posTestContentPage;
	
	@BeforeMethod
	public void Setup() {
		System.out.println("This class contains tests to verify the POS website features");
		System.out.println("Execution starts: BuyInsuranceTest");
		
		System.setProperty("webdriver.chromer.driver", "D:\\Learnings\\Drivers\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.pos.com.my/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//instantiate an object
		posTestPageElements = new POS_TestPage_Elements(driver);	
		posTestContentPage = new POS_testPages(driver);

	}
	
	@AfterMethod
	public void TearDown() {
		System.out.println("After class settings done");
		System.out.println("Execution ends: BuyInsuranceTest");
		if (driver != null) 
		{
			driver.close();
		}	
	}		
}
