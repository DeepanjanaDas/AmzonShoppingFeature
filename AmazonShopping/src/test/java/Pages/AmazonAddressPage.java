package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableMethods.CommonMethods;

public class AmazonAddressPage extends CommonMethods {

	@FindBy(xpath = "(//div[@class='ship-to-this-address a-button a-button-primary a-button-span12 a-spacing-medium  '])[1]")
	WebElement DeliverToTheAddress_button;

	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement continueToAddress;

	public void clickDeliverToAddress() {
		AmazonAddressPage amazonAddressPage = PageFactory.initElements(driver, AmazonAddressPage.class);
		waiting(amazonAddressPage.DeliverToTheAddress_button);
		clicking(amazonAddressPage.DeliverToTheAddress_button);
		waiting1(amazonAddressPage.continueToAddress);
		clicking(amazonAddressPage.continueToAddress);

	}

}
