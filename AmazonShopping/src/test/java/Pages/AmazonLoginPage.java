package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableMethods.CommonMethods;
import StepDef.Hooks;


public class AmazonLoginPage extends CommonMethods  {

Hooks hooks = new Hooks();
	
	
	@FindBy (xpath = "//span[text() = 'Hello, Sign in']")
	WebElement SignIn_Button;
	
	@FindBy (xpath = "//input[@type = 'email']")
	WebElement UserEmail;
	
	@FindBy (xpath = "//input[@id = 'continue']")
	WebElement Continue_button;

	@FindBy (xpath = "//input[@type = 'password']")
	WebElement Password;
	
	@FindBy (xpath = "//input[@name='rememberMe']")
	WebElement KeepmeSignedIn_checkbox;
	
	@FindBy (xpath = "//input[@id = 'signInSubmit']")
	WebElement Login_button;
	
	public void openAmazonlandingpage(String url) 
	{
		
		driver.get(url);
	}
	public void clickSignin() 
	{
		AmazonLoginPage amazonLoginPage = PageFactory.initElements(driver, AmazonLoginPage.class);
		clicking(amazonLoginPage.SignIn_Button);
		waiting(amazonLoginPage.UserEmail);
	}
	public void providesCredentials(String userName, String Password) 
	{
		AmazonLoginPage amazonLoginPage = PageFactory.initElements(driver, AmazonLoginPage.class);
		passingText(amazonLoginPage.UserEmail,userName);
		clicking(amazonLoginPage.Continue_button);
		waiting(amazonLoginPage.Password);
		passingText(amazonLoginPage.Password, Password);
		clicking(amazonLoginPage.KeepmeSignedIn_checkbox);
		clicking(amazonLoginPage.Login_button);
		System.out.println("User has logged in.");
	}
}
