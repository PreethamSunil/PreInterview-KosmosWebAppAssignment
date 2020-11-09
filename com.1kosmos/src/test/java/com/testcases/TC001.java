package com.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.Page02_AccountCreation;

public class TC001 extends TestBase {

	public Page02_AccountCreation Ac;
	public String SheetName = "Account";

	@Test(priority = 1)
	public void Step1_WebSiteLoad() {
		logger.info("----Test1 Started: Description: Ensure the website load----");
		// Test:Step1 == Ensure this website loads: https://www.mypedia.pearson.com/
		Lp.pageloadwait();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.mypedia.pearson.com/login");
		logger.info("----Test1 Completed: Description: Ensure the website load----");
	}

	@Test(priority = 2)
	public void languagedropdownCount() throws InterruptedException {
		// Step 2: Confirm that language dropdown has at least 3 languages
		logger.info("----Test2 Started: Description:  Confirm that language dropdown has at least 3 languages----");
		driver.navigate().refresh();
		Lp.cmdClickdropdown();
		Lp.cmddropdownListCountCheck(3);
		logger.info("----Test2 Completed: Description:  Confirm that language dropdown has at least 3 languages----");
	}

	@Test(priority = 3)
	public void selectlangauage() throws InterruptedException {
		// Step3: Auto-Select different languages and validate that the label of the
		// [CONTINUE] button changes to selected language.
		logger.info("----Test3 Started: Description:  Auto-Select different languages and validate that the label of the\r\n"
				+ "		// [CONTINUE] button changes to selected language.----");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("English", "CONTINUE");
		map.put("?????", "?????? ????");
		map.put("Español", "CONTINUAR");
		int langOptCount = Lp.cmddropdownListCount();
		System.out.println("value is " + langOptCount);
		for (int i = 0; i < langOptCount; i++) {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			Lp.cmdClickMenuItem(i);
			String lang = Lp.cmdLangSelected();
			if (lang.contains("?????")) {
				String value = map.get("?????");
				Assert.assertEquals(value, Lp.cmdContinueButtontext());
			} else if (lang.contains("English")) {
				String value = map.get("English");
				Assert.assertEquals(value, Lp.cmdContinueButtontext());
			} else if (lang.contains("Español")) {
				String value = map.get("Español");
				Assert.assertEquals(value, Lp.cmdContinueButtontext());
			}
			Lp.cmdClickdropdown();
		}
		Lp.cmdClickMenuItem(0);
		logger.info("----Test3 Completed: Description:  Auto-Select different languages and validate that the label of the\r\n"
				+ "		// [CONTINUE] button changes to selected language.----");

	}

	@Test(priority = 4)
	public void AccountSetup() throws IOException, InterruptedException {
		// Click on "setup parent support" -> Create a new account. Fill all the details
		// to create an account. Make this data driven so it could be executed multiple
		// times.
		// Assert that "create account" button is disabled till all fields are filled
		
		logger.info("----Test4 Started: Description: Account Created -- Data Driven----");
		int rowcount = dd.getRowCount("Account");

		for (int i = 1; i <= rowcount; i++) {
				Lp.cmdClickParentSupport();
				Lp.cmdCreateAccount();
				Ac = new Page02_AccountCreation(driver);

				Ac.cmdEnterFirstName(dd.getValue(SheetName, i, 0));
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Disabled");

				Ac.cmdEnterLastName(dd.getValue(SheetName, i, 1));
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Disabled");

				Ac.cmdEnterEmail(dd.getValue(SheetName, i, 2));
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Disabled");

				Ac.cmdParentUsername(dd.getValue(SheetName, i, 3));
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Disabled");

				Ac.cmdParentPassword(dd.getValue(SheetName, i, 4));
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Disabled");

				Ac.cmdConfirmPassword(dd.getValue(SheetName, i, 4));
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Disabled");

				Ac.cmdSelectCountry(dd.getValue(SheetName, i, 5));
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Disabled");

				Ac.cmdEnterCaptcha("qwe");
				Assert.assertEquals(Ac.cmdCreateAccountEnablePropertycheck(), "Enabled");

				Thread.sleep(4000);
				driver.navigate().back();
						
		}
		logger.info("----Test4 Completed: Description: Account Created -- Data Driven----");
	}
	
}
