package com.undostres.helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	private static String propertyFilePath = System.getProperty("user.dir") + "/src/com/wow/resources/validation.properties";

	public static boolean verifyElementDisplayed(WebElement element) {
		boolean isDisplayed = true;
		try {
			element.getTagName();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	public static boolean verifyElementnotDisplayed(WebElement element) {
		return !verifyElementDisplayed(element);
	}

	public static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {

		}
		return str;
	}


	public static String readPropertyFile(String propertyPath, String key) throws Exception
	{
		InputStream input = new FileInputStream(propertyPath);
		Properties prop = new Properties();
		prop.load(input);
		String value = prop.getProperty(key);
		return value;
	}

	public static void waitUntilElementIsVisible(WebDriver driver,WebElement element) {
	    ExpectedCondition<Boolean> expectation = _driver -> element.isDisplayed();
	    Wait<WebDriver> wait = new WebDriverWait(driver, 10);
	    try {
	        wait.until(webDriver -> expectation);
	    } catch (Throwable ignored) {
	    }
	}
	
	public static void waitUntilElementIsEnabled(WebDriver driver,WebElement element) {
	    ExpectedCondition<Boolean> expectation = _driver -> element.isEnabled();
	    Wait<WebDriver> wait = new WebDriverWait(driver, 10);
	    try {
	        wait.until(webDriver -> expectation);
	    } catch (Throwable ignored) {
	    }
	}


}
