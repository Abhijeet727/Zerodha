package TempTest;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Pack1.HeaderSectionIcons;
import Pack1.LoginPageZerodha;
import Pack1.MarketWatchAndSerachBoxSection;
import Pack1.ShareBuyAndSellWindow;
import Pack1.TourKite;
import SetUp.BaseZerodha;

public class VerifyBuyAndSellStock extends BaseZerodha{

private WebDriver driver;
private LoginPageZerodha loginPageZerodha;
private ShareBuyAndSellWindow shareBuyAndSellWindow;
private MarketWatchAndSerachBoxSection marketWatchAndSerachBoxSection;
	
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
		marketWatchAndSerachBoxSection = new MarketWatchAndSerachBoxSection(driver);
		shareBuyAndSellWindow = new ShareBuyAndSellWindow(driver);

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

	@Test
	public void buyStock() throws InterruptedException
	{
		marketWatchAndSerachBoxSection.selectStockFromWatchList();
		marketWatchAndSerachBoxSection.clickOnbuyShareButton();
		
		Thread.sleep(4000);
		shareBuyAndSellWindow.clickOnMISradioButton();
		shareBuyAndSellWindow.clickOnLimitRadioButton();
		shareBuyAndSellWindow.sendQuantityNo();
		shareBuyAndSellWindow.SetPrice();
	//	shareBuyAndSellWindow.clickOnBuyOrSellButton();
		shareBuyAndSellWindow.clickOncancleButton();
	}
	
	@Test 
	public void sellStock() throws InterruptedException
	{
		marketWatchAndSerachBoxSection.selectStockFromWatchList();
		marketWatchAndSerachBoxSection.clickOnsellShareButton();
		Thread.sleep(4000);

		//shareBuyAndSellWindow.clickOnCNCradioButton();
		shareBuyAndSellWindow.clickOnLimitRadioButton();
		shareBuyAndSellWindow.sendQuantityNo();
		shareBuyAndSellWindow.SetPrice();
	//	shareBuyAndSellWindow.clickOnBuyOrSellButton();
		shareBuyAndSellWindow.clickOncancleButton();
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
		shareBuyAndSellWindow = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		 driver.close();	
		 driver= null;
		 System.gc();
	}
	
}
