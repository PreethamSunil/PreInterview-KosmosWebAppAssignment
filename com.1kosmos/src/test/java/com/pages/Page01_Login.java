/**
 * 
 */
package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utilities.UT01_WaitHelper;

/**
 * @author Preetham Sunil
 *
 */
public class Page01_Login {

	public WebDriver ldriver;
	public UT01_WaitHelper wh;

	public Page01_Login(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new UT01_WaitHelper(rdriver);

	}

	@FindBy(id = "SI_0001")
	WebElement imgPearson;

	@FindBy(xpath = "//div[@class='accountDetailsLangDropDown']//div[2]")
	WebElement drpLanguage;

	@FindBy(xpath = "//span[@role='menuitem']")
	WebElement dropLists;

	@FindBy(xpath = "//div[@role='menu']")
	WebElement dropMenu;

	@FindBy(linkText = "Set up parent support")
	WebElement lnkParentSupport;
	
	@FindBy(xpath = "//*[@id='SI_0005']/div/div")
	WebElement btnContinue;
	
	@FindBy(xpath = "//span[text()='CREATE A NEW ACCOUNT']")
	WebElement btnCreateAccount;
	
	

	By MenuLists = By.xpath("//span[@role='menuitem']");

	public void cmdClickParentSupport() {
		wh.waitHelp(lnkParentSupport, 30);
		lnkParentSupport.click();
	}

	public void cmdClickPearsonImage() {
		wh.waitHelp(imgPearson, 30);
		imgPearson.click();
	}

	public void cmdClickdropdown() {
		wh.waitHelp(drpLanguage, 30);
		drpLanguage.click();
	}
	
	public void cmdClickMenuItem(int itemnum) {
		List<WebElement> element = ldriver.findElements(MenuLists);
		wh.waitHelp(element.get(itemnum), 60);
		element.get(itemnum).click();
		System.out.println("My selection is " + element.get(itemnum).getText());
		
	}

	public void pageloadwait() {
		WebDriverWait wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.urlToBe("https://www.mypedia.pearson.com/login"));
	}

	public void cmddropdownListCountCheck(int expectedcount) {
		List<WebElement> listcount = ldriver.findElements(MenuLists);
		if (listcount.size() >= expectedcount) {
			Assert.assertTrue(true);
			System.out.println(
					"The list count is " + listcount.size() + " Expected is greater than or Equal to " + expectedcount);
		} else {

			Assert.assertTrue(false);
			System.out.println(
					"The list count is " + listcount.size() + " Expected is greater than or Equal to " + expectedcount);

		}
	}

	
	public int cmddropdownListCount() {
		List<WebElement> listcount = ldriver.findElements(MenuLists);
		return listcount.size();
	}
	
	
	public String cmdContinueButtontext()
	{
		wh.waitHelp(btnContinue, 30);
		System.out.println("My button text is " + btnContinue.getText());
		return btnContinue.getText();
		
	}
	
	public String cmdLangSelected()
	{
		wh.waitHelp(drpLanguage, 30);
		System.out.println("My label text is " + drpLanguage.getText());
		return drpLanguage.getText();
		
	}
	
	public void cmdCreateAccount()
	{
		wh.waitHelp(btnCreateAccount, 30);
		btnCreateAccount.click();
	}

	
}
