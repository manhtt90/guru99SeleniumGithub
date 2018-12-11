package Flash_Testing;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Flash.FlashObjectWebDriver;

public class Flash {
	public static void main(String[] args) throws InterruptedException {
		// Open firefox browser
		WebDriver driver = new ChromeDriver();
		
/*		ChromeOptions options = new ChromeOptions();
		// disable ephemeral flash permissions flag
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		Map<String, Object> prefs = new HashMap<>();
		// Enable flash for all sites for Chrome 69
		prefs.put("profile.content_settings.exceptions.plugins.*,*.setting", 1);

		options.setExperimentalOption("prefs", prefs);
		ChromeDriver driver = new ChromeDriver(options);*/

		// Maximize browser
		driver.manage().window().maximize();
		// Under Flash jar file there is separate FlashObjectWebDriver class
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		// Pass the URL of video
		
		//driver.get("http://demo.guru99.com/test/flash-testing.html");
		//Allow Flash on specific URL
		driver.get("chrome://settings/content/siteDetails?site=http%3A%2F%2Fdemo.guru99.com");
		Thread.sleep(2000);
		System.out.println("0");
		Select drpFlash = new Select(driver.findElement(By.id("permission")));
		System.out.println("1");
		drpFlash.selectByVisibleText("allow");
		System.out.println("2");
		Thread.sleep(2000);
		
		driver.navigate().to("http://demo.guru99.com/test/flash-testing.html");
		Thread.sleep(5000);
		// click button to enable Adobe Flash Player
		// driver.findElement(By.name("myFlashMovie"));
		flashApp.callFlashObject("Play");
		Thread.sleep(5000);
		flashApp.callFlashObject("StopPlay");
		Thread.sleep(5000);
		flashApp.callFlashObject("SetVariable", "/:message", "Flash testing using selenium Webdriver");
		System.out.println(flashApp.callFlashObject("GetVariable", "/:message"));
	}
}
