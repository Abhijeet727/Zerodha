package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketWatchAndSerachBoxSection {

	private WebDriver driver;
	Actions act;
	
	@FindBy(xpath= "//input[@type='text']")
	private WebElement searchBox;

	@FindBy(xpath= "(//ul[@class='omnisearch-results']//div//li)[1]")
	private WebElement selectSearchStockFromList;

	@FindBy(xpath= "//span[@class='symbol']")
	private WebElement selectStock;

	@FindBy(xpath= "(//button[@type='button'])[1]")
	private WebElement buyShare;
	
	@FindBy(xpath= "(//button[@type='button'])[2]")
	private WebElement sellShare;

	@FindBy(xpath= "(//button[@type='button'])[3]")
	private WebElement marketDepth;

	@FindBy(xpath= "(//button[@type='button'])[4]")
	private WebElement chart;

	@FindBy(xpath= "(//button[@type='button'])[5]")
	private WebElement deleteStockFromWatchlist;

	@FindBy(xpath= "(//button[@type='button'])[6]")
	private WebElement more;
	
	
	
	public MarketWatchAndSerachBoxSection(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void searchStockAndAddInWatchList()
	{
		act = new Actions(driver);
		searchBox.sendKeys("idea");
		act.moveToElement(selectStock).click().build().perform();
	}
	
	public void selectStockFromWatchList() throws InterruptedException
	{
		act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(selectStock).build().perform();
	}
	
	public void clickOnbuyShareButton()
	{
		buyShare.click();	
	}

	public void clickOnsellShareButton()
	{
		sellShare.click();	
	}

	public void clickOnMarketDepthButton() throws InterruptedException
	{
		act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(selectStock).build().perform();
		marketDepth.click();	
	}

	public void clickOnChartButton() throws InterruptedException
	{
		act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(selectStock).build().perform();
		chart.click();	
	}

	public void clickOndeleteStockButton()
	{
		deleteStockFromWatchlist.click();	
	}

}
