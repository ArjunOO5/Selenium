package internetHeroku;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages2 {

	public static void main(String[] args) throws IOException {
		// Open Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://the-internet.herokuapp.com/");
		//click on Broken images link
		driver.findElement(By.linkText("Broken Images")).click();
		//creating http req
		List <WebElement> imagesElements = driver.findElements(By.tagName("img"));
		System.out.println(imagesElements.size());

		for(WebElement img :imagesElements)
		{
			String sttString= img.getAttribute("src");
			URL url = new URL(sttString);
			URLConnection urlConnection = url.openConnection();   
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
			httpsURLConnection.setConnectTimeout(300);
			httpsURLConnection.connect();

			if(httpsURLConnection.getResponseCode()== 200 )
			{

				System.out.println(sttString + ">> " + httpsURLConnection.getResponseCode() + ">>" + httpsURLConnection.getResponseMessage() );
			}
			else {
				System.err.println(sttString + ">> " + httpsURLConnection.getResponseCode() + ">>" + httpsURLConnection.getResponseMessage() );
				httpsURLConnection.disconnect();

			}


		}

		driver.quit();

	}

}
