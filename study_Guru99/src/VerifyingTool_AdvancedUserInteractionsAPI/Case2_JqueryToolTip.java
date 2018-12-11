package VerifyingTool_AdvancedUserInteractionsAPI;

import org.openqa.selenium.interactions.Actions;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.*;		

public class Case2_JqueryToolTip {				
    public static void main(String[] args) {									
     
        String baseUrl = "http://demo.guru99.com/test/tooltip.html";					      
        WebDriver driver = new ChromeDriver();					
        String expectedTooltip = "What's new in 3.2";					
        driver.get(baseUrl);					
        
        //Find the WebElement that corresponds to the element "download now" that we will mouse-hover.
        WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));							
        Actions builder = new Actions (driver);							

        //Using the Interactions API, mouse hover on to the "Download now"
        builder.clickAndHold().moveToElement(download);					
        builder.moveToElement(download).build().perform(); 	
        
        //Assuming the tooltip is displayed, find the WebElement that corresponds to the link inside the tooltip i.e. the "a" tag.
        WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));							
        String actualTooltip = toolTipElement.getText();			
        
        System.out.println("Actual Title of Tool Tip:  "+actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }		
        driver.close();			
   }		
}		