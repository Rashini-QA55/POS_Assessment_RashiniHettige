package com.pos.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.pos.elements.POS_TestPage_Elements;

public class POS_testPages {

	WebDriver driver;
	POS_TestPage_Elements posTestPageElements;

	public POS_testPages(WebDriver driver) {
		this.driver = driver;
		posTestPageElements = new POS_TestPage_Elements(driver);
	}

	/**
	 * Click on buy insurance button
	 */
	public void clickBuyInsuranceBtn() {
		posTestPageElements.buyInsuranceBtn.click();
	}

	/**
	 * Click ride car button
	 */
	public void clickRideCarBtn() {
		posTestPageElements.rideCarButton.click();
	}

	/**
	 * Click ride motorbicycle buttons
	 */
	public void clickRideBicycleBtn() {
		posTestPageElements.rideMotorCycleButton.click();
	}

	/**
	 * is questions area displayed
	 */
	public boolean isQuestionsAreaDisplayed() {
		return posTestPageElements.questionsArea.isDisplayed();
	}
	/**
	 * Click parcel sub menu
	 */
	public void clickParcelButton() {
		posTestPageElements.parcelSubMenuIcon.click();
	}
	/**
	 * get e-Consignment form content 
	 */
	public List<WebElement> getConsignmentFormContent(){
		return posTestPageElements.consignmentFormContent;
	}
}
