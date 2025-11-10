package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BasePage_testcases;

public class TC003_LogoutPage extends BasePage_testcases {

	@Test(groups= {"Master","Regression"})
	public void logout() throws InterruptedException {
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
		Thread.sleep(3000);
		LogoutPage lp = new LogoutPage(driver);
		logger.info("*******After Login the website");
		lp.getMyAccount();
		logger.info("********Clicked the myAccount");
		lp.getLogoutBtn();
		logger.info("********Clicked the logout button");
		lp.getContinueBtn();
		logger.info("********Successfully logout from the page*********************");

	}
}
