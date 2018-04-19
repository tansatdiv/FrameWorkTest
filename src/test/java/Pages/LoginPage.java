package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
		
	}
	
	@FindBy(id="account_sign_in_form_email_id") WebElement userName;
	@FindBy(id="account_sign_in_form_passwd_id") WebElement passWord;
	@FindBy(id="send2") WebElement logInButton;
	
	By signOut = By.xpath(".//a[text()='Log Out']");
	
	
	public void loginApplication(String user, String pass){
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		logInButton.click();
		
		
	}
	
	public void verifyLogOutLink(){
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signOut));
		String text =  ele.getText();
		assertEquals(text, "Log Out", "Log Out link is not found");
		
		
	}
	
}
