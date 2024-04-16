package internetHeroku;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {

	public static void main(String[] args) {
		//Intiate Chrome driver
		ChromeDriver driver	 = new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://the-internet.herokuapp.com/");
		// click on broken images link
		driver.findElement(By.partialLinkText("Broken Images")).click();
		// collect all image elements]
		List <WebElement> imagElements = driver.findElements(By.tagName("img"));

		for(WebElement findimg :imagElements) {

			if(findimg.getAttribute("naturalWidth").equals("0"))
			{
				System.out.println("The image is broken"+imagElements);
			}

			else {
				System.out.println("The image is not broken "+imagElements);
			}

		}


	}

}

