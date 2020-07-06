package Pages;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import ResuableMethods.CommonMethods;


	public class AmazonPaymentPage extends CommonMethods{

		@FindBy (xpath = "//h1[text()='Select a payment method']")
		WebElement PaymentPage_check;
		
		public void verifyPaymentPage()
		{
			AmazonPaymentPage amazonPaymentPage= PageFactory.initElements(driver, AmazonPaymentPage.class);
			waiting(amazonPaymentPage.PaymentPage_check);
			if(amazonPaymentPage.PaymentPage_check.isDisplayed()==true)
			{
				System.out.println("User has successfully navigated to payment page");
			}
			else
			{
				System.out.println("Navigation was unsuccessful");
			}
			
			screenCapture();
		}
	}

	
	
	

