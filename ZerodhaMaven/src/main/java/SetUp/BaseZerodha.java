package SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseZerodha {

	public static WebDriver openChromeBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "G:\\Selenium Automation\\Firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;		
	}
	
	public static WebDriver openIEBrowser()
	{
		System.setProperty("webdriver.ie.driver", "G:\\Selenium Automation\\InternetExplorer\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();	
		return driver;
	}

}
