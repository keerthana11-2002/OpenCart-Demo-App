package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BasePage_testcases;

public class TC001_AccountRegistrationTest extends BasePage_testcases {

	@Test(groups= {"Regression","Master"})
	public void verify_accRegister() {
		logger.info("******** Starting TC001_AccountRegistration Test *******");
		try {
		
		
		HomePage obj = new HomePage(driver);
		obj.clickMyAccount();
		logger.info("***Clicked on myAccount Link..... ***");

		obj.clickRegister();
		logger.info("***Clicked on Register Link..... ***");

		RegisterPage obj2 = new RegisterPage(driver);
		logger.info("***Providing customer details..... ***");

		obj2.setFname(randomString().toUpperCase());
		obj2.setlname(randomString().toUpperCase());
		obj2.setEmail(randomString() + "@gmail.com");
		obj2.setTelephone(randomNumber());
		String password = randomAlphaNum();
		obj2.setpassword(password);
		obj2.setConfirmpassword(password);

		obj2.setPolicyBtn();
		obj2.setBtn();
		logger.info("***Validating expected message..... ***");

		String confmsg = obj2.getConfirmation();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);

		}
 		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*********Finished TC001_AccountRegistration Test*********");
	}

	
}
