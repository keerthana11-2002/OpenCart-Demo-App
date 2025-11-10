package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LogoutPage extends BasePage {
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutbtn;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public void getMyAccount() {
		myAccount.click();
	}

	public void getLogoutBtn() {
		logoutbtn.click();
	}

	public void getContinueBtn() {
		continueBtn.click();
	}
}
