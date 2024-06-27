package com.postest.org.pos_assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class BuyInsuranceTest extends AbstractBaseTest {


	@Test
	public void verifyBuyInsurance() {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		WebElement heading = posTestPageElements.header; 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", heading);
		wait.until(ExpectedConditions.elementToBeClickable(posTestPageElements.buyInsuranceBtn));
		posTestContentPage.clickBuyInsuranceBtn();
	
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String expectedUrl = "https://insurance.pos.com.my/";
		wait.until(ExpectedConditions.urlToBe(expectedUrl));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Url is verified!");
		
		wait.until(ExpectedConditions.elementToBeClickable(posTestPageElements.rideCarButton)); 
		wait.until(ExpectedConditions.elementToBeClickable(posTestPageElements.rideMotorCycleButton)); 
		
		
		Random random = new Random();
		if (random.nextBoolean()) {
			posTestContentPage.clickRideCarBtn();
			System.out.println("Clicked on 'I ride a car button'");
		} 
		else {
			posTestContentPage.clickRideBicycleBtn();
			System.out.println("Clicked on 'I ride a motorcycle'");
		}

		wait.until(ExpectedConditions.visibilityOf(posTestPageElements.questionsArea));
		Actions action = new Actions(driver);	
		action.moveToElement(posTestPageElements.questionsArea);	
		Assert.assertTrue(posTestContentPage.isQuestionsAreaDisplayed(), "Verify the new section appeared on the page");
        System.out.println("New section has appeared on the page: " + posTestPageElements.questionsArea.getText());           
        
	}
						
	@Test
	public void creatingConsignmentNote() {

		WebElement sendMenu = posTestPageElements.sendMenuIcon;
		Actions actions = new Actions(driver);
		actions.moveToElement(sendMenu).perform();
		posTestContentPage.clickParcelButton();
		
		wait.until(ExpectedConditions.urlToBe("https://www.pos.com.my/send/send-parcel"));
		WebElement cashPanel = posTestPageElements.cashPanelArea;
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", cashPanel);

		wait.until(ExpectedConditions.elementToBeClickable(posTestPageElements.shipmentButton)).click();
	
		String expectedUrl = "https://send.pos.com.my/home/e-connote?lg=en";
		wait.until(ExpectedConditions.urlToBe(expectedUrl));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl, "Verify the new page url");
		if (expectedUrl.equals(actualUrl)) {
			String title = driver.getTitle();
			System.out.println("The title of the page : " + title);
		}
		else 
		{
			System.out.println("User should be able to get e-Consignment forms. Please check the url again!");
		}
		
		posTestContentPage.getConsignmentFormContent(); //driver.findElements(By.cssSelector("div.tab-title"));
		for (WebElement content : posTestContentPage.getConsignmentFormContent()) {
			if (content.isDisplayed()) {
				String sectionHeaders = content.getText();
				System.out.print(sectionHeaders);
				System.out.println("--------------------");
			} else {
				System.out.println("Unable to display e-consignment forms.Please check the url again!");
			}
		}
	}
	
}
		
