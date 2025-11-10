package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BasePage_testcases;
import utilityFiles.DataProviders;

public class LoginDP_testcase extends BasePage_testcases {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups= "DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("******Starting loginDP****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			logger.info("******Providing customer details*****");
			LoginPage lp = new LoginPage(driver);
			lp.setemail(p.getProperty("email"));
			lp.setpassword(p.getProperty("password"));
			lp.setLoginBtn();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);

				}
			}
			if (exp.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
					 SoftAssert objAssert = new SoftAssert();
					 objAssert.assertEquals(targetPage, targetPage);
					 objAssert.assertAll();

				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

	}
}
