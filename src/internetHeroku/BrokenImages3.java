package internetHeroku;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages3 {

	public static void main(String[] args) throws IOException {
		// initate chrome driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//switch frame
		WebElement framElement = driver.findElement(By.xpath("(//iframe[@id='courses-iframe'])[1]"));
		driver.switchTo().frame(framElement);
		// collect img web elements
		List<WebElement> imgsrcElements = driver.findElements(By.tagName("img"));
		System.out.println(imgsrcElements.size());
		System.out.println();
		// for loops

		for(WebElement imagesElement :imgsrcElements)
		{
			String srcString = imagesElement.getAttribute("src");
			System.out.println(srcString);
				URL url =new URL(srcString);
				URLConnection urlConnection = url.openConnection();
				HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection ;
				httpsURLConnection.setConnectTimeout(300);
				httpsURLConnection.connect();
				if(httpsURLConnection.getResponseCode()==200)

				{
					System.out.println(srcString + ">>>" + httpsURLConnection.getResponseCode()+">>>"+ httpsURLConnection.getResponseMessage());
				}

				else {
					System.err.println(srcString + ">>>" + httpsURLConnection.getResponseCode()+">>>"+ httpsURLConnection.getResponseMessage());
				}		   

			driver.quit();
		}
	}

}
