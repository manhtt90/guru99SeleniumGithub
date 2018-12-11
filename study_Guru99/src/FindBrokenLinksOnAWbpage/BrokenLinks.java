package FindBrokenLinksOnAWbpage;

import java.io.IOException;
//Using the methods in this package, we can send HTTP requests and capture HTTP response codes from the response.
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String homePage = "http://24h.com.vn";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(homePage);

		// Step 2: Collect all links in web page
		// Identify all links in a webpage and store them in List.
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// Obtain Iterator to traverse through the List.
		Iterator<WebElement> it = links.iterator();

		// Step 3: Identifying and Validating URL
		// In this part, we will check if URL belongs to Third party domain or whether
		// URL is empty/null
		while (it.hasNext()) {// hasNext() method returns true if the given document contains another string.
								// Hence why the snippet will loop if said document has another string. Once
								// there are no more Strings in the entire document, hasNext() returnsfalse
			// Get href of anchor tag and store it in url variable.
			url = it.next().getAttribute("href");
			System.out.println("Step 3: " +url);
			// if URL is null or Empty and
			if (url == null || url.isEmpty()) {
				System.out.println("- URL is either not configured for anchor tag or it is empty");
				continue;
			}
			//if URl belongs to another domain, skip the remaining steps
			if (!url.startsWith(homePage)) {
				System.out.println("Step 3: URL belongs to another domain, skipping it.");
				continue;
			}

			// Step 4: Send http request
			try {
				// HttpURLConnection class has methods to send HTTP request and capture HTTP
				// response code. So, output of openConnection() method (URLConnection) is type
				// casted to HttpURLConnection
				huc = (HttpURLConnection) (new URL(url).openConnection());
				// We can set Request type as "HEAD" instead of "GET". So that only headers are
				// returned and not document body.
				huc.setRequestMethod("HEAD");
				// On invoking connect() method, actual connection to url is established and the
				// request is sent
				huc.connect();

				// Step 5: Validating Links
				// Using getResponseCode() method we can get response code for the request
				respCode = huc.getResponseCode();
				// Based on response code we will try to check link status.
				if (respCode >= 400) {
					System.out.println("Step 5: " +url + " is a broken link with respCode >=400");
				} else {
					System.out.println("Step 5: " +url + " is a valid link with satisfied respCode");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// driver.quit();

	}
}
