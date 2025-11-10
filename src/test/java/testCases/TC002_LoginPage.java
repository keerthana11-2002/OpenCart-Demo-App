package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BasePage_testcases;

public class TC002_LoginPage extends BasePage_testcases {
	@Test(groups= {"Sanity","Master"})
	public void login() {
		logger.info("*******Starting Login Page**************");
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
			Assert.assertTrue(targetPage);

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("********Finished TC002_LoginPage");
	}

}
