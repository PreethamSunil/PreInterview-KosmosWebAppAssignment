package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UT01_WaitHelper {

	public WebDriver ldriver;

	public UT01_WaitHelper(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void waitHelp(WebElement ele, int timeunit) {
		WebDriverWait wait = new WebDriverWait(ldriver, timeunit);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitHelpProcessing(WebElement ele, int timeunit)
	{
		WebDriverWait wait = new WebDriverWait(ldriver, timeunit);
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}


	

}
