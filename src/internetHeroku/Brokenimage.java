package internetHeroku;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenimage {

	public static void main(String[] args) throws IOException {
		// Inintiate Chrome Driver 
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://the-internet.herokuapp.com/");
		//click on broken image link 
		driver.findElement(By.linkText("Broken Images")).click();
		// collect images
		List <WebElement> imagelist = driver.findElements(By.tagName("img"));
		//for loop

		for(WebElement imageElement:imagelist) 
		{
			String srcString = imageElement.getAttribute("src");

			URL url = new URL(srcString);
			URLConnection urlConnection = url.openConnection();
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection)urlConnection;
			httpsURLConnection.setConnectTimeout(400);
			httpsURLConnection.connect();

			if (httpsURLConnection.getResponseCode()==200) {

				System.out.println(srcString +">>"+ httpsURLConnection.getResponseCode()+">>"+ httpsURLConnection.getResponseMessage());
			}
			else {
				System.err.println(srcString +">>"+ httpsURLConnection.getResponseCode()+">>"+ httpsURLConnection.getResponseMessage());	

			}

		}



		//exit
		driver.quit();
	}

}


