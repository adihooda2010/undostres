package com.undostres.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	private WebDriver driver;

	@FindBy(name = "operator") WebElement operatorTextField;

	@FindBy(className = "suggestion") WebElement dataOpertaor;

	@FindBy(name = "mobile") WebElement mobileTextField;
	
	@FindBy(name = "amount") WebElement amountField;
	
	@FindBy(css = "[data-name='10']") WebElement amountDollar10;
	
	@FindBy(css=".buttonRecharge") WebElement submit;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterOperatorName(String operatorName) {
		operatorTextField.sendKeys(operatorName);
	}

	public void selectOperatorName(){
		dataOpertaor.click();
	}
	
	public void enterMobileNumber(String mobileNumber) {
		mobileTextField.sendKeys(mobileNumber);
	}
	
	public void clickOnAmount() {
		amountField.click();
	}
	
	public void select10Dollar() {
		amountDollar10.click();
	}

	public void clickOnsubmit() {
		submit.click();
	}

}
