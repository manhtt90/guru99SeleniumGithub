package guru99.gittest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String baseUrl = "http://demo.guru99.com";					
        WebDriver driver = new ChromeDriver();					
        driver.get(baseUrl);					
        String eTitle = "Meet Guru99";
        String aTitle = "";
                
        aTitle = driver.getTitle();
        
        if(aTitle.equals(eTitle)) {							
            System.out.println("Test Case Passed");					
        }	else {
            System.out.println("Test Case Failed");					
        }
    }
}
