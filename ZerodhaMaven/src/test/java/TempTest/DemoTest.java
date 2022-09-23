package TempTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pack1.LoginPageZerodha;
import Pack1.MarketWatchAndSerachBoxSection;
import Pack1.ShareBuyAndSellWindow;

public class DemoTest {

	private WebDriver driver;
	
	public static void main(String [] args) throws InterruptedException {
	
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
System.setProperty("webdriver.chrome.driver", "G:\\Selenium Automation\\chromedriver.exe");
		
	WebDriver driver = new ChromeDriver();
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	driver.get("https://kite.zerodha.com/");
	driver.manage().window().maximize();
		
	LoginPageZerodha loginPageZerodha = new LoginPageZerodha(driver);
		
	loginPageZerodha.sendUserName();
	loginPageZerodha.sendPassward();
	loginPageZerodha.clickOnLoginButton();
	loginPageZerodha.sendPinNo();
	loginPageZerodha.clickOnContinueButton();
	
	Thread.sleep(5000);
	
	MarketWatchAndSerachBoxSection marketWatchAndSerachBoxSection = 
			new MarketWatchAndSerachBoxSection(driver);
	
	marketWatchAndSerachBoxSection.searchStockAndAddInWatchList();
	
	
	
	
	
	
	
	
	
	
//	marketWatchAndSerachBoxSection.selectStockFromWatchList();
//	marketWatchAndSerachBoxSection.clickOnbuyShareButton();
//	
//	ShareBuyAndSellWindow shareBuyAndSellWindow = new ShareBuyAndSellWindow(driver);
//	shareBuyAndSellWindow.clickOnMISradioButton();
//	shareBuyAndSellWindow.clickOnLimitRadioButton();
//	shareBuyAndSellWindow.sendQuantityNo();
//	shareBuyAndSellWindow.SetPrice();
//	shareBuyAndSellWindow.clickOnBuyOrSellButton();
	}
}
