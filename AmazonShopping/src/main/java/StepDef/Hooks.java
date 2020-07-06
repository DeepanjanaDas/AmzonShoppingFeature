package StepDef;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static Properties pro;
	public static WebDriver driver;
	public Hooks()
	{
		File f = new File ("./SystemConfiguration/config.property");
		try {
			FileInputStream fls = new FileInputStream(f);
			pro = new Properties();
			pro.load(fls);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getConfigValue(String key)
	{
		return pro.getProperty(key);
	}
	
	@Before
	public void openBrowser()
	{
		Hooks u = new Hooks();
		switch (u.getConfigValue("browser")) {
		case ("chrome"):
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"./Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		driver.manage().window().maximize();
			break;
			
		case ("InternetExplorer"):
			driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
			break;
			
		case ("Firefox"):
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
			
			break;
		default:
			break;
		}
		
	}
	
	@After	
	public void closeBrowser()
		{
			driver.quit();
		}
	
	
}


