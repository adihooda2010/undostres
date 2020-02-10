package com.undostres.script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.undostres.helper.Utils;

public class BaseClass {
	public static WebDriver driver;
	List<String> items;
	private static String propertyFilePath = System.getProperty("user.dir") + "/src/com/undostres/resources/env.properties";

	@BeforeTest(alwaysRun = true)
	public void startServer() throws Exception {
		System.out.println("before test");
		String URL = Utils.readPropertyFile(propertyFilePath, "URL");
		String browser = Utils.readPropertyFile(propertyFilePath, "Browser");
		System.out.println(URL);
		init(URL,browser);
	}
	@AfterTest
	public void stopServer() {
		driver.close();
		driver.quit();
	}

	public static WebDriver init(String website, String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(website);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(website);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(website);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	
}
