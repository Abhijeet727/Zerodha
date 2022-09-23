package TempTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pack1.HeaderSectionIcons;
import Pack1.LoginPageZerodha;
import Pack1.MarketWatchAndSerachBoxSection;
import Pack1.TourKite;
import SetUp.BaseZerodha;

public class VerifyTourKite extends BaseZerodha{

	private WebDriver driver;
	private LoginPageZerodha loginPageZerodha;
	private SoftAssert soft;
	private TourKite tourKite;
	private HeaderSectionIcons headerSectionIcons;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}	
		
		if(browserName.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
		if(browserName.equals("IE"))
		{
			driver = openIEBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@BeforeClass
	public void createPOMObjects()
	{
		loginPageZerodha = new LoginPageZerodha(driver);
		tourKite = new TourKite(driver);
		headerSectionIcons = new HeaderSectionIcons(driver);
	}
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		driver.get("https://kite.zerodha.com/");
			
		loginPageZerodha.sendUserName();
		loginPageZerodha.sendPassward();
		loginPageZerodha.clickOnLoginButton();
		loginPageZerodha.sendPinNo();
		loginPageZerodha.clickOnContinueButton();
	}
	
	@Test (priority = 0)
	public void verifyTourKite() throws InterruptedException
	{		
		headerSectionIcons.clickOnProfileDropDownIcon();
		Thread.sleep(2000);
		
		tourKite.clickontourKite();
		tourKite.clickonNextButton();
		tourKite.clickonNextButton();
		tourKite.clickonNextButton();
		tourKite.clickonNextButton();
		tourKite.clickonDoneButton();
	}

	@AfterMethod
	public void logout() throws InterruptedException
	{
		 loginPageZerodha.logout();
	}
	
	@AfterClass
	public void cleanPOMObjects()
	{
		loginPageZerodha = null;
		tourKite = null;
		headerSectionIcons = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		 driver.close();	
		 driver= null;
		 System.gc();
	}
}
