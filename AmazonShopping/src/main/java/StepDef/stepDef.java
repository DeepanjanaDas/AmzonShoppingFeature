package StepDef;

import Pages.AmazonAddressPage;
import Pages.AmazonCartPage;
import Pages.AmazonHomePage;
import Pages.AmazonLoginPage;
import Pages.AmazonPaymentPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDef {
	Hooks utility = new Hooks();
	AmazonLoginPage amazonLoginPage = new AmazonLoginPage();
	AmazonHomePage amazonHomePage = new AmazonHomePage();
	AmazonCartPage amazonCartPage = new AmazonCartPage();
	AmazonAddressPage amazonAddressPage = new AmazonAddressPage();
	AmazonPaymentPage amazonPaymentPage = new AmazonPaymentPage();
		
		@Given("^User is on Amazon landing page on hitting \"([^\"]*)\"$")
		public void openAmazonlandingpageStep(String url) 
		{
			amazonLoginPage.openAmazonlandingpage(url);
		}

		@When("^User clicks on sign in tab$")
		public void clickSigninStep()
		{
			amazonLoginPage.clickSignin();
		}

		@When("^User logs in by providing \"([^\"]*)\" and \"([^\"]*)\"$")
		public void providesCredentialsStep(String userName, String Password) 
		{
			amazonLoginPage.providesCredentials(userName, Password);
		}

		@When("^User is on Amazon Home page with \"([^\"]*)\"$")
		public void verifyAmazonHomeStep(String name)
		{
			amazonHomePage.verifyAmazonHome(name);
		}

		@When("^User search by providing \"([^\"]*)\" in search bar$")
		public void searchItemInSearchbarStep(String itemName) 
		{
			amazonHomePage.searchItemInSearchbar(itemName);
		}

		@When("^User choose specific item$")
		public void chooseSpecificItemStep()
			{
			amazonHomePage.chooseSpecificItem();
		}

		@When("^User clicks on Add to Cart option for that item$")
		public void clickAddtoCartoptionStep() 
		{
			
			amazonHomePage.clickAddtoCartoption();
		}

		@Then("^User validate that particular item with \"([^\"]*)\" quanitity in the cart$")
		public void GoToCartStep(String number)
		{
			amazonCartPage.GoToCart(number);
		}

		@Then("^User click on Proceed to Buy option$")
		public void clickProceedToBuyStep()
		{
			amazonCartPage.clickProceedToBuy();
		}

		@Then("^User click on Deliver to the Address$")
		public void clickDeliverToAddressStep()
		{
			amazonAddressPage.clickDeliverToAddress();
		}

		@Then("^User now is on Payment page$")
		public void verifyPaymentPageStep()
		{
			
		}


}
