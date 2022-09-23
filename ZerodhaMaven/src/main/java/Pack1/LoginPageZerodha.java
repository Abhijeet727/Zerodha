package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageZerodha {
	
	private WebDriver driver;

	@FindBy(xpath= "//input[@id='userid']")
	private WebElement userName;

	@FindBy(xpath= "//input[@id='password']")
	private WebElement passward;

	@FindBy(xpath= "//button[text()='Login ']")
	private WebElement loginButton;

	@FindBy(xpath= "//input[@id='pin']")
	private WebElement pin;

	@FindBy(xpath= "//button[text()='Continue ']")
	private WebElement continueButton;

	@FindBy(xpath= "//span[text()='LI7776']")
	private WebElement userId;
	
	@FindBy(xpath= "//a[text()=' Logout']")
	private WebElement logout;

	
	
	public LoginPageZerodha(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

public void sendUserName() throws InterruptedException
{
	Thread.sleep(3000);
	if(userName.isDisplayed())
		{
		userName.sendKeys("LI7776");
		}
}

public void sendPassward()
{
	passward.sendKeys("Anurag@2811");
}

public void clickOnLoginButton()
{
	loginButton.click();	
}

public void sendPinNo()
{
	pin.sendKeys("338333");
}

public void clickOnContinueButton()
{
	continueButton.click();	
}

public void logout() throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(userId));
	userId.click();
	wait.until(ExpectedConditions.visibilityOf(logout));
	logout.click();
}

}


