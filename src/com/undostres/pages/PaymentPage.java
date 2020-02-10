package com.undostres.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.undostres.helper.Utils;

public class PaymentPage {
	private WebDriver driver;

	@FindBy(css = ".summary-message.messageShowTop") WebElement summaryMessage;

	@FindBy(xpath = "//*[@class='list-group-item text-center select-card active']//*[text()='Tarjeta']") WebElement paymentMode;

	
	@FindBy(xpath  = "//div[@class='field form-group']//input[@class='form-control cardname']") WebElement cardNameField;
	
	@FindBy(xpath = "//div[@class='field input-group']//input[@class='form-control cardnumber']") WebElement cardNumberField;
	
	@FindBy(xpath = "//div[@class='field col-xs-5 col-md-5 paddleft0']//input[@class='form-control expmonth']") WebElement expMonthField;
	@FindBy(xpath = "//div[@class='field col-xs-7 col-md-7 paddleft0']//input[@class='form-control expyear']") WebElement expYearField;
	@FindBy(xpath = "//div[@class='field form-group']//input[@class='form-control cvv']") WebElement cvvNumberField;
	@FindBy(xpath = "//div[@class='field form-group']//input[@class='form-control email']") WebElement emailField;
	@FindBy(name="formsubmit") WebElement submit;
	
	@FindBy(id = "usrname") WebElement popUpEmail;
	@FindBy(id = "psw") WebElement popUpPass;
	@FindBy(css = ".g-recaptcha") WebElement captcha;
	@FindBy(id = "loginBtn") WebElement loginButton;
	@FindBy(id = "add_err") WebElement successMsg;
	
	@FindBy(css=".recaptcha-checkbox-checkmark") WebElement captchaCheckmark;
	
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatePaymentPage() {
		Utils.waitUntilElementIsVisible(driver, summaryMessage);
		if(summaryMessage.isDisplayed())
		{
			System.out.println("Payment Page is opened");
		}
		else
		{
			System.out.println("Payment page is not opened");
		}
	}

	public void clickOnPaymentMode(){
		paymentMode.click();
	}
	
	public void enterCardName(String cardName) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value='Test';", cardNameField);
		cardNameField.click();
		cardNameField.sendKeys(cardName);
	}
	
	public void enterCardNumber(String cardNumber) {
		cardNumberField.sendKeys(cardNumber);
	}
	public void enterExpDate(String expMonth, String expYear, String cvv) {
		expMonthField.sendKeys(expMonth);
		expYearField.sendKeys(expYear);
		cvvNumberField.sendKeys(cvv);
	}
	
	public void enterEmailID(String email) {
		emailField.sendKeys(email);
	}
	public void clickOnsubmit() {
		submit.click();
	}

	public void enterEmailOnPopUp(String email)
	{
		popUpEmail.sendKeys(email);
	}
	
	public void enterPasswordOnPopUp(String pass)
	{
		popUpPass.sendKeys(pass);
	}
	
	public void clickOnCaptcha()
	{
		Utils.waitUntilElementIsVisible(driver, captcha);
	
		captcha.click();
	}
	
	public void clickOnLoginButton() throws Exception
	{
		Utils.waitUntilElementIsVisible(driver, captchaCheckmark);
		Thread.sleep(3000);
		if(loginButton.isEnabled())
		{
			loginButton.click();
		}
		else
			System.out.println("Login button is not enabled");
	}
	
	public void verifySuccessMsg(String msg) throws Exception
	{
		Utils.waitUntilElementIsVisible(driver, successMsg);
		Thread.sleep(2000);
		if(successMsg.getText().equals(msg))
		{
			System.out.println("Actual Message "+ successMsg.getText());
			System.out.println("Recharge is successful");
		}
		else
		{
			System.out.println("Actual Message "+ successMsg.getText());
			System.out.println("Recharge is not successful");
		}
	}

}
