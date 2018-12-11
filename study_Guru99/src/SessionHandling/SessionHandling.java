package SessionHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class SessionHandling {
	@BeforeTest
	public void launchBrowser() {
		// First session of WebDriver
		WebDriver driver = new FirefoxDriver();
		// Goto guru99 site
		driver.get("http://demo.guru99.com/V4/");

		// Second session of WebDriver
		WebDriver driver2 = new FirefoxDriver();
		// Goto guru99 site
		driver2.get("http://demo.guru99.com/V4/");
	}
	
	@Test
    public void Test(){
        System.out.print("Test");
    }
	
	@AfterTest
    public void terminateBrowser(){
        System.out.print("AfterTest");
    }
}

