package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableMethods.CommonMethods;

public class AmazonCartPage extends CommonMethods {

	@FindBy(xpath = "//h1")
	WebElement AddedtoCart_message;

	@FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
	WebElement Cart_button;

	@FindBy(xpath = "//span[@class='a-size-medium sc-product-title a-text-bold']")
	WebElement Cart_Item_List;

	@FindBy(xpath = "//input[@value='Proceed to checkout']")
	WebElement ProceedToBuy_button;

	String CartAdded_item = "//form[@id = 'activeCartViewForm']//div[@data-name = 'Active Items']//div//following-sibling::div//div[@class='sc-list-item-content']//span[@class='a-size-medium sc-product-title a-text-bold']";
	
	String itemsList= "//div[@data-name='Active Items']//div[@data-itemtype='active']//ul//a[contains(@href,'product')]/span[contains(@class,'a-size')]"; 
	
	@FindBy(xpath = "//select[@name = 'quantity']")
	WebElement dropdownForQuantity;

	String delete_button = "(//form[@id = 'activeCartViewForm']//input[@value='Delete'])";
	
	String delete= "(//div[@data-name='Active Items']//div[@data-itemtype='active']//ul/following-sibling::div//span[@data-action='delete'])";
	
	@FindBy(xpath = "(//a[contains(text(), 'Deliver to this address')])[1]")
	WebElement DeliverToAddress_button;

	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement Continue_button;

	public void GoToCart(String number) {
		AmazonCartPage amazonCartPage = PageFactory.initElements(driver, AmazonCartPage.class);
		waiting(amazonCartPage.AddedtoCart_message);
		String itemAdded_message = amazonCartPage.AddedtoCart_message.getText();
		String s1 = "Added to Cart";

		if (itemAdded_message.contains(s1)) {

			System.out.println("item is successfully added");
			clicking(amazonCartPage.Cart_button);
		} else {
			Assert.assertEquals(true, false);
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

			e.printStackTrace();
		}
		String item_name = driver.findElements(By.xpath(CartAdded_item)).get(0).getText();
		int item_count = driver.findElements(By.xpath(CartAdded_item)).size();
		int item_delete_count = driver.findElements(By.xpath(delete_button)).size();
		if (item_count > 1) {
			for (int i = 0; i < item_count; i++) {
				for(int j = i+1; j <= item_delete_count; j++)
				{
				
				if (!item_name.equalsIgnoreCase(driver.findElements(By.xpath(CartAdded_item)).get(i).getText()))
						 {

					  
					       System.out.println(delete_button + "[" + j + "]");
					       clicking(driver.findElement(By.xpath(delete_button + "[" + j + "]")));
					       item_count = driver.findElements(By.xpath(CartAdded_item)).size();
					       i=0;
				}

			}
			
		}
	}
		else

		{

			System.out.println("only selected items are present in the cart");
		}
		waiting(amazonCartPage.dropdownForQuantity);
		selectDropdown(amazonCartPage.dropdownForQuantity, number);
	}


	
	
	public void clickProceedToBuy() {
		AmazonCartPage amazonCartPage = PageFactory.initElements(driver, AmazonCartPage.class);
		waiting(amazonCartPage.ProceedToBuy_button);
		clicking(amazonCartPage.ProceedToBuy_button);
		System.out.println("User has proceeded to buy item");
		System.out.println("User has navigated to address page");
	}
	
}