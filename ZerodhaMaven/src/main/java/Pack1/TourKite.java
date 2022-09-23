package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TourKite {

	private WebDriver driver;

	@FindBy (xpath = "//a[text()=' Tour Kite']")
	private WebElement tourKiteButton;
	
	@FindBy (xpath = "//button[text()='Next']")
	private WebElement nextButton;
	
	@FindBy (xpath = " //button[text()='Done']")
	private WebElement doneButton;
	
	public TourKite(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickontourKite() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(tourKiteButton));
		tourKiteButton.click();
	}
	
	public void clickonNextButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(nextButton));
		nextButton.click();
	}
	
	public void clickonDoneButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(doneButton));
		doneButton.click();
	}
}
