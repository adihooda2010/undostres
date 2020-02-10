package com.undostres.script;

import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.undostres.pages.HomePage;
import com.undostres.pages.PaymentPage;


public class RechargeScript extends BaseClass{

	@Test(testName = "Click on recharge and verify next page")
	public void clickOnRecharge() throws Exception {
		HomePage homePage = new HomePage(getDriver());
		PaymentPage paymentPage = new PaymentPage(getDriver());
		homePage.enterOperatorName("telcel");
		homePage.selectOperatorName();
		homePage.enterMobileNumber("5523261151");
		homePage.clickOnAmount();
		homePage.select10Dollar();
		homePage.clickOnsubmit();
		paymentPage.validatePaymentPage();
		paymentPage.clickOnPaymentMode();
		paymentPage.enterCardName("Test");
		paymentPage.enterCardNumber("4111111111111111");
		paymentPage.enterExpDate("11", "2025", "111");
		paymentPage.enterEmailID("test@test.com");
		paymentPage.clickOnsubmit();
		paymentPage.enterEmailOnPopUp("marze.zr@gmail.com");
		paymentPage.enterPasswordOnPopUp("123456");
		paymentPage.clickOnCaptcha();
		paymentPage.clickOnLoginButton();
		paymentPage.verifySuccessMsg("success");
	}
	
}
