package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSectionIcons {

	@FindBy(xpath= "(//div[@id='app']//a)[2]")
	private WebElement dashBoard;

	@FindBy(xpath= "(//div[@id='app']//a)[3]")
	private WebElement orders;

	@FindBy(xpath= "(//div[@id='app']//a)[4]")
	private WebElement holdings;

	@FindBy(xpath= "(//div[@id='app']//a)[5]")
	private WebElement positions;

	@FindBy(xpath= "(//div[@id='app']//a)[6]")
	private WebElement funds;

	@FindBy(xpath= "(//div[@id='app']//a)[7]")
	private WebElement apps;

	@FindBy(xpath= "(//div[@id='app']//a)[8]")
	private WebElement profileDropDown;

		
	
	public HeaderSectionIcons(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


public void clickOnDashBoardIcon()
{
	dashBoard.click();	
}

public void clickOnOrdersIcon()
{
	orders.click();	
}
public void clickOnHoldingsIcon()
{
	holdings.click();	
}
public void clickOnPositionsIcon()
{
	positions.click();	
}
public void clickOnFundsIcon()
{
	funds.click();	
}
public void clickOnAppsIcon()
{
	apps.click();	
}
public void clickOnProfileDropDownIcon()
{
	profileDropDown.click();	
}

	
}
