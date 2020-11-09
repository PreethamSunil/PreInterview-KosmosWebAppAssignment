package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.UT01_WaitHelper;

public class Page02_AccountCreation {

	public WebDriver ldriver;
	public UT01_WaitHelper wh;

	public Page02_AccountCreation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new UT01_WaitHelper(rdriver);
	}

	@FindBy(xpath = "//label[text()='First name']/following::input")
	WebElement txtFirstName;

	@FindBy(xpath = "//label[text()='Last name']/following::input")
	WebElement txtLastName;

	@FindBy(xpath = "//label[text()='Email address']/following::input")
	WebElement txtEmail;

	@FindBy(xpath = "//label[text()='Create parent username']/following::input")
	WebElement txtParentUsername;

	@FindBy(xpath = "//input[@type='password']")
	WebElement txtParentPassword;

	@FindBy(xpath = "//label[text()='Confirm password']/following::input")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//div[text()='Country']")
	WebElement drpCountry;

	@FindBy(xpath = "//div[text()='School']")
	WebElement drpSchool;

	@FindBy(xpath = "//span[@label='India']")
	WebElement drpIndiaSelect;

	@FindBy(xpath = "//span[@label='South Africa']")
	WebElement drpSouthAfricaSelect;

	@FindBy(xpath = "//span[text()='CREATE ACCOUNT']")
	WebElement btnCreateAccount;

	@FindBy(xpath = "//label[text()='Validate Captcha']/following::input")
	WebElement txtCaptcha;

	@FindBy(xpath = "//*[text()='Loading...']")
	WebElement eleProcessing;

	@FindBy(xpath = "//span[@role='menuitem']")
	WebElement lstCountry;

	By countrylists = By.xpath("//span[@role='menuitem']");

	public void cmdEnterFirstName(String fname) {
		wh.waitHelp(txtFirstName, 30);
		txtFirstName.sendKeys(fname);
	}

	public void cmdEnterLastName(String lname) {
		wh.waitHelp(txtLastName, 30);
		txtLastName.sendKeys(lname);
	}

	public void cmdEnterEmail(String email) {
		wh.waitHelp(txtEmail, 30);
		txtEmail.sendKeys(email);
	}

	public void cmdParentUsername(String uname) {
		wh.waitHelp(txtParentUsername, 30);
		txtParentUsername.sendKeys(uname);
	}

	public void cmdParentPassword(String pwd) {
		wh.waitHelp(txtParentPassword, 30);
		txtParentPassword.sendKeys(pwd);
	}

	public void cmdConfirmPassword(String pwd) {
		wh.waitHelp(txtConfirmPassword, 30);
		txtConfirmPassword.sendKeys(pwd);
	}

	public void cmdSelectCountry(String Country) {
		// wh.waitHelp(drpCountry, 30);
		// drpCountry.click();
		wh.waitHelp(drpCountry, 60);
		drpCountry.click();
		wh.waitHelp(lstCountry, 60);
		List<WebElement> ctylist = ldriver.findElements(countrylists);
		for (WebElement elem : ctylist) {
			if (elem.getText().equals(Country)) {
				elem.click();
			} else {
				System.out.println("Invalid Country Provided");
			}

		}

	}

	public void cmdSelectSchool() {
		wh.waitHelp(drpSchool, 30);
		drpSchool.click();
	}

	public void cmdIndiaSelect() {
		wh.waitHelp(drpIndiaSelect, 30);
		drpIndiaSelect.click();
	}

	public void cmdSASelect() {
		wh.waitHelp(drpSouthAfricaSelect, 30);
		drpSouthAfricaSelect.click();
	}

	public void cmdEnterCaptcha(String captcha) {
		wh.waitHelp(txtCaptcha, 30);
		txtCaptcha.sendKeys(captcha);
	}

	public String cmdCreateAccountEnablePropertycheck() {
		String result = "Pending";
		wh.waitHelp(btnCreateAccount, 30);
		String btnproperties = btnCreateAccount.getAttribute("style");
		System.out.println("------" + btnproperties);
		if (btnproperties.contains("opacity: 0.3")) {
			System.out.println("The button is disabled ");
			result = "Disabled";
		} else if (btnproperties.contains("opacity: 1")) {
			System.out.println("The button is enabled ");
			result = "Enabled";
		}
		return result;
	}

	
	
	
}
