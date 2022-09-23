package TempTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pack1.LoginPageZerodha;
import Pack1.MarketWatchAndSerachBoxSection;
import SetUp.BaseZerodha;

public class VerifySerachBoxAndChartPage extends BaseZerodha{

	private WebDriver driver;
	private LoginPageZerodha loginPageZerodha;
	private MarketWatchAndSerachBoxSection marketWatchAndSerachBoxSection;
	private SoftAssert soft;
	
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
		marketWatchAndSerachBoxSection =new MarketWatchAndSerachBoxSection(driver);
	//	driver = new ChromeDriver();

	}
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.get("https://kite.zerodha.com/");
				
		loginPageZerodha.sendUserName();
		loginPageZerodha.sendPassward();
		loginPageZerodha.clickOnLoginButton();
		loginPageZerodha.sendPinNo();
		loginPageZerodha.clickOnContinueButton();
	}
	
	@Test
	public void serachStockAndAddToWatchlist()
	{		
		marketWatchAndSerachBoxSection.searchStockAndAddInWatchList();

		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		soft = new SoftAssert();
		
		soft.assertEquals(url, "https://kite.zerodha.com/dashboard");
		soft.assertEquals(title, "Dashboard / Kite");
		soft.assertAll();
	}
	
	@Test 
	public void verifyStocksChart() throws InterruptedException
	{		
		marketWatchAndSerachBoxSection.clickOnMarketDepthButton();
		marketWatchAndSerachBoxSection.clickOnChartButton();
		
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		soft = new SoftAssert();

		soft.assertEquals(url, "https://kite.zerodha.com/chart/web/tvc/NSE/IDEA/3677697");
		soft.assertAll();
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
		marketWatchAndSerachBoxSection = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		 driver.close();	
		 driver= null;
		 System.gc();
	}
	
	
}
