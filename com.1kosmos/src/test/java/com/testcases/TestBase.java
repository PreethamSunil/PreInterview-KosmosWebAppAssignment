package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.pages.Page01_Login;
import com.utilities.UT02_ReadConfig;
import com.utilities.UT04_DataDriven;

public class TestBase {

	public WebDriver driver;
	public UT02_ReadConfig rc;
	public Logger logger;
	public String browser = "chrome";
	public Page01_Login Lp;
	public UT04_DataDriven dd;
	@BeforeSuite
	public void Setup() throws IOException {

		logger = Logger.getLogger("Automation Logger");
		PropertyConfigurator.configure("../com.1kosmos/log4j.properties");
		logger.info("----------Automation Scripts are Strated----------- ");

		System.setProperty("webdriver.chrome.driver", "../com.1kosmos/drivers/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		logger.info("Chrome Browser has been Initiated");

		rc = new UT02_ReadConfig();
		driver.get(rc.getUrl());
		logger.info("Launched the URL " + rc.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		Lp = new Page01_Login(driver);
		dd = new UT04_DataDriven();

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
		logger.info("---------Driver has been Terminated Successfully---------");

	}

}
