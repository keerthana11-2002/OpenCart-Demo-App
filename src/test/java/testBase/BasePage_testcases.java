package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage_testcases {
	protected static WebDriver driver;// u can use public access but i created one more basepage in same package so we
	// need to write in protected
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws InterruptedException, IOException {

		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilties = new DesiredCapabilities();
			if (os.equalsIgnoreCase("windows")) {
				capabilties.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilties.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("Linux")) {
				capabilties.setPlatform(Platform.LINUX);
			} else {
				System.out.println("No matching os");
				return;
			}
			
			switch (br.toLowerCase()) {
			case "chrome":capabilties.setBrowserName("chrome");break;
			case "edge":capabilties.setBrowserName("edge");break;
			case "firefox":capabilties.setBrowserName("firefox");break;
			default:System.out.println("No matching browser ...");return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilties);
		}

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name...");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;

	}

	public String randomNumber() {
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;

	}

	public String randomAlphaNum() {
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return (generatedNum + generatedString);
	}

	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilepath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timeStamp + ".png";
		File targetFile = new File(targetFilepath);
		sourceFile.renameTo(targetFile);
		return targetFilepath;
	}

}
