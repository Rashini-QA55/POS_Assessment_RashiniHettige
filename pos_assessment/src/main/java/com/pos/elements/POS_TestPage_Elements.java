package com.pos.elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POS_TestPage_Elements {
	
	WebDriver driver;
	
	@FindBy(css="h1.ng-tns-c47-0") public WebElement header;
	@FindBy(xpath="//a[@href='https://insurance.pos.com.my']") public WebElement buyInsuranceBtn;
	@FindBy(xpath="//div[@class='content medium']") public WebElement rideCarButton;
	@FindBy(xpath="//div[@class='content d-block ms-5 medium']") public WebElement rideMotorCycleButton;
	@FindBy(css="h5.mb-4") public WebElement questionsArea;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/app-floating-bar[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]") public WebElement sendMenuIcon;
	@FindBy(linkText="Parcel") public WebElement parcelSubMenuIcon;
	@FindBy(xpath="//div[@class='col-md-4']") public WebElement cashPanelArea;
	@FindBy(xpath="//div[contains(text(),'Create shipment now')]") public WebElement shipmentButton;
	@FindBy(css="div.tab-title") public List<WebElement> consignmentFormContent;
	
	public POS_TestPage_Elements(WebDriver driver) {
		
		this.driver = driver; //whatever the driver passed is passed by the user, that will be treated as the driver of this class
		PageFactory.initElements(driver, this);		
	}
	
}
