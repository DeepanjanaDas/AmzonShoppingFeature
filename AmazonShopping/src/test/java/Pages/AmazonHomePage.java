package Pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableMethods.CommonMethods;

public class AmazonHomePage extends CommonMethods {

	@FindBy(xpath = "//h2[contains(text(),'Hi')]")
	WebElement Hi_message;

	@FindBy(xpath = "//span[contains(text(),'Hello')]")
	WebElement helloUser;

	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	WebElement Search_Box;

	@FindBy(xpath = "//span[contains(text(),'Go')]")
	WebElement searchIcon;

	@FindBy(xpath = "(//span[@class= 'a-size-base-plus a-color-base a-text-normal'])[1]")
	WebElement item;
	
	@FindBy(xpath = "//a[@title='See All Buying Options']")
	WebElement SeeAllbuyOption_button;

	@FindBy(xpath = "(//input[@value='Add to cart'])[1]")
	WebElement AddTocart_button;

	String xgh = "//input[@id='add-to-cart-button']";

	public void verifyAmazonHome(String name) {
		AmazonHomePage amazonHomePage = PageFactory.initElements(driver, AmazonHomePage.class);
		waiting(amazonHomePage.helloUser);
		if (amazonHomePage.helloUser.getText().toLowerCase().contains(name.substring(0, name.indexOf('.')))) {
			System.out.println("User has navigated on home page successfully");
		}

		else {
			System.out.println("Login was unsuceessful");
			org.junit.Assert.assertEquals(true, false);
		}
	}

	public void searchItemInSearchbar(String itemName) {
		AmazonHomePage amazonHomePage = PageFactory.initElements(driver, AmazonHomePage.class);

		passingText(amazonHomePage.Search_Box, itemName);
		enterAction();
		System.out.println("User searched for an item");

	}

	public void chooseSpecificItem() {
		AmazonHomePage amazonHomePage = PageFactory.initElements(driver, AmazonHomePage.class);
		waiting(amazonHomePage.item);
		clicking(amazonHomePage.item);
		System.out.println("User chose a specific item");
	}

	public void clickAddtoCartoption() {
		AmazonHomePage amazonHomePage = PageFactory.initElements(driver, AmazonHomePage.class);
		window_handles();
		clicking(amazonHomePage.SeeAllbuyOption_button);
		waiting(amazonHomePage.AddTocart_button);
		clicking(amazonHomePage.AddTocart_button);
		System.out.println("Item is added to cart");

	}
	
}