package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btnPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtMessageConfirm;

	public void setFname(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setlname(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String mail) {
		txtEmail.sendKeys(mail);
	}

	public void setTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}

	public void setpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmpassword(String pwd) {
		txtPasswordConfirm.sendKeys(pwd);
	}

	public void setPolicyBtn() {
		btnPolicy.click();
	}

	public void setBtn() {
		btnContinue.click();
	}

	public String getConfirmation() {
		try {
			return (txtMessageConfirm.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	 
}
