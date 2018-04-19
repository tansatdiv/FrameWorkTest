package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage (WebDriver ldriver){
		
		this.driver=ldriver;
	}
	
	@FindBy(xpath = "//a[text()='Log In']") WebElement signInLink;
	@FindBy(xpath = "//a[text()='My Account']") WebElement myAccountLink;
	@FindBy(xpath = "//a[text()='My Cart']") WebElement myCartLink;
	@FindBy(xpath = "//a[text()='Checkout']") WebElement checkOutLink;
	
	
	public void clickOnSignInLink(){
		signInLink.click();
	}
	
	public void clickOnMyAccountLink(){
		myAccountLink.click();
	}
	
	public  void clickOnMyCartLink(){
		myCartLink.click();
	}
	public  void clickOnCheckoutLink(){
		checkOutLink.click();
	}

	public String getTitle(){
		return driver.getTitle();
	}
}
