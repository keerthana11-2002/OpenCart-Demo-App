package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	public void setemail(String mail) {
		email.sendKeys(mail);
	}
	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void setLoginBtn() {
		loginbtn.click();
	}

}
