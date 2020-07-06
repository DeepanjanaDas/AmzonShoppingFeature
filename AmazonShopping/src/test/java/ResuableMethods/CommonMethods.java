package ResuableMethods;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDef.Hooks;



public class CommonMethods extends Hooks{
	
	
	public void clicking(WebElement e)
	{
		e.click();
	}
	
	public void passingText(WebElement e, String text)
	{
		e.sendKeys(text);
	}
	
	public void waiting(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void waiting1(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	
	public void selectDropdown(WebElement e, String text)
	{
		Select s1 = new Select(e);
		s1.selectByVisibleText(text);
		
	}
	
	public void enterAction()
	{
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void window_handles()
	{
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows)
		{
			if (!parent.equalsIgnoreCase(child))
				driver.switchTo().window(child);
		}
	}
	
	
	public void screenCapture()
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		
			//FileInputStream fileInputStream= new FileInputStream(f);
			try {
				FileUtils.copyFile(f, new File (".\\ScreenshotAmazon\\result.jpg"));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
	

}
