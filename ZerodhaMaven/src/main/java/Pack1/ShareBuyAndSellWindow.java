package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShareBuyAndSellWindow {

	@FindBy(xpath= "(//input[contains(@id,'radio')])[1]")
	private WebElement bseButton;

	@FindBy(xpath= "(//input[contains(@id,'radio')])[2]")
	private WebElement nseButton;

	@FindBy(xpath= "(//label)[8]")
	private WebElement misButton;

	@FindBy(xpath= "(//input[contains(@id,'radio')])[8]")
	private WebElement cncButton;

	@FindBy(xpath= "(//input[contains(@id,'radio')])[9]")
	private WebElement marketButton;

	@FindBy(xpath= "(//label)[14]")
	private WebElement limitButton;

	@FindBy(xpath= "(//input[contains(@id,'radio')])[11]")
	private WebElement stopLossButton;
	
	@FindBy(xpath= "(//input[@type='number'])[1]")
	private WebElement quantity;

	@FindBy(xpath= "(//input[@type='number'])[2]")
	private WebElement price;

	@FindBy(xpath= "(//input[@type='number'])[3]")
	private WebElement triggerPrice;

	@FindBy(xpath= "(//div[@class='six columns text-right actions']//button)[1]")
	private WebElement buyOrSellButton;

	@FindBy(xpath= "(//div[@class='six columns text-right actions']//button)[2]")
	private WebElement cancleButton;
	
		
	
	public ShareBuyAndSellWindow(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


public void clickOnBSEradioButton()
{
	bseButton.click();	
}

public void clickOnNSEradioButton()
{
	nseButton.click();	
}

public void clickOnMISradioButton()
{
	misButton.click();	
}
	
public void clickOnCNCradioButton()
{
	cncButton.click();
}
	
public void clickOnMarketRadioButton()
{
	marketButton.click();
}
	
public void clickOnLimitRadioButton()
{
	limitButton.click();
}
	
public void clickOnSLCradioButton()
{
	stopLossButton.click();
}
	
public void sendQuantityNo()
{
	quantity.sendKeys("1");
}
	
public void SetPrice()
{
	price.clear();
	price.sendKeys("3.50");
}
	
public void SetTriggerPrice()
{
	triggerPrice.clear();
	triggerPrice.sendKeys("1.80");
}

public void clickOnBuyOrSellButton()
{
	buyOrSellButton.click();
}
	
public void clickOncancleButton()
{
	cancleButton.click();
}


	}
