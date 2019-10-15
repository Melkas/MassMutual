package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		
		if (driver == null) {
			
		switch (ConfigurationReader.getProperty("browser"))
		{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				ChromeOptions option = new ChromeOptions();
                DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setPlatform(Platform.ANY);
				
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
	
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}
}

